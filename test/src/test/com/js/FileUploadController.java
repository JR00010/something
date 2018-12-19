package test.com.js;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.daotong.controllers.base.DaoTongBaseController;
import com.daotong.core.conf.WebMappingTables;
import com.shove190.core.plugins.data.ActionResult;

/**
 * 视频上传类
 */
@RestController
public class FileUploadController extends DaoTongBaseController {

    @Value("${savePath}")
    private String savePath;

    /**
     * 视频分片上传公共接口，考虑到用户效率，采用MD5算法确认文件唯一性，理论上文件不同而摘要相同的概率几近于0，对于发生hash碰撞的两个文件，
     * 其得到的视频将会是与其发生hash碰撞的视频。
     *
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = WebMappingTables.MAPPING_WEB_COMMON_FIELUPLOADCONTROLLER)
    public ActionResult upload(MultipartFile fileData) throws IllegalStateException, IOException, Exception {
        // 搜素目录下是否包含有相同的MD5文件？

        int total = Integer.valueOf(request.getParameter("total"));// 总片数
        int index = Integer.valueOf(request.getParameter("index"));// 当前是第几片,第一片index必须为0
        String fileMd5 = request.getParameter("fileMd5"); // 整个文件的md5
        // 文件夹位置
        File parent = new File(savePath + File.separator + fileMd5);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        // 文件分片位置
        File file = new File(parent, fileMd5 + "_" + index);
        // 保存分片到本地
        if (file.exists()) {
            file.delete();
        }
        // 由前端控制上传进度
        fileData.transferTo(file);

        // 判断所有分片是否全部上传完成，完成则合并
        File dir = new File(savePath + File.separator + fileMd5);
        File[] files = dir.listFiles();
        if (files.length == total) {// 上传完成
            FileOutputStream fileOutputStream = null;
            FileInputStream temp = null;// 文件分片
            File newFile = new File(dir, fileMd5);

            fileOutputStream = new FileOutputStream(newFile, true);
            byte[] byt = new byte[10 * 1024 * 1024];
            int len;

            for (int i = 0; i < total; i++) {
                temp = new FileInputStream(new File(dir, fileMd5 + "_" + i));
                while ((len = temp.read(byt)) != -1) {
                    fileOutputStream.write(byt, 0, len);
                }
            }
            fileOutputStream.close();
            temp.close();
            // 全部完成之后，删除分片
            for (int i = 0; i < total; i++) {
                File splitFile = new File(dir, fileMd5 + "_" + i);
                if (splitFile.exists()) {
                    splitFile.delete();
                }
            }
        }
        return buildActionResult("操作成功");
    }

    /**
     * 获取文件的MD5值
     */
    private String getFileMD5(File file) {
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        // 16进制
        return bigInt.toString(16);
    }

    /**
     * 检测视频是否已上传
     */
    @RequestMapping(value = WebMappingTables.MAPPING_WEB_COMMON_FIELUPLOADCONTROLLER_ISFILEEXIST)
    public ActionResult<Object> isFileExist() {
        File pdir = new File(savePath);
        if (!pdir.exists()) {
            pdir.mkdirs();
        }

        ActionResult<Object> actionResult = new ActionResult<Object>();

        String fileMd5 = request.getParameter("fileMd5");

        File dir = new File(savePath + File.separator + fileMd5);

        if (dir.exists()) {// 目录存在
            File file = new File(dir, fileMd5);
            if (file.exists()) {// 文件存在
                actionResult.setCode(1);
                actionResult.setMsg("文件已上传，秒传");
                return actionResult;
            } else {// 文件不存在，计算分片大小
                actionResult.setCode(-1);
                actionResult.setMsg("文件已部分上传");
                return actionResult;
            }
        } else {
            actionResult.setCode(-1);
            actionResult.setMsg("文件未上传");
            return actionResult;
        }
    }

    /**
     * 检测视频分片是否已上传
     */
    @RequestMapping(value = WebMappingTables.MAPPING_WEB_COMMON_FIELUPLOADCONTROLLER_ISFILESPLITEXIST)
    public ActionResult<Object> isFileSplitExist() {
        ActionResult<Object> actionResult = new ActionResult<>();

        String splitMd5 = getReqStringParams("md5");// 分片Md5
        String fileMd5 = getReqStringParams("fileMd5");// 文件md5
        int index = getReqIntegerParams("index");// 第几片

        File file = new File(savePath + File.separator + fileMd5, fileMd5 + "_" + index);
        if (file.exists()) {
            if (splitMd5.equals(getFileMD5(file))) {
                actionResult.setCode(1);
                actionResult.setMsg("视频分片已上传");
                return actionResult;
            } else {// 视频分片损坏，删除重传
                file.delete();

                actionResult.setCode(-1);
                actionResult.setMsg("视频分片已损坏");
                return actionResult;
            }
        } else {
            actionResult.setCode(-1);
            actionResult.setMsg("视频分片未上传");
            return actionResult;
        }

    }
    public static void main(String[] args) {
        File file=new File("E:\\saveFileDir\\f18215e2014b70b78e30ce2af989643a\\f18215e2014b70b78e30ce2af989643a");
        System.out.println(new FileUploadController().getFileMD5(file));
        //f18215e2014b70b78e30ce2af989643a
        //f18215e2014b70b78e30ce2af989643a
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
    }
}
