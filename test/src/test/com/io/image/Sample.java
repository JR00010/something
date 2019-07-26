package test.com.io.image;

import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.qcloud.image.ImageClient;
import com.qcloud.image.exception.AbstractImageException;
import com.qcloud.image.request.IdcardDetectRequest;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "15796405";
    public static final String API_KEY = "p40cdmtV5mV5zIfBQWkPl3if";
    public static final String SECRET_KEY = "060GnLDYyif4pPLsGNeAsV7q09S002DT";
    static String bucketName = "";//历史遗留字段, 无需修改

    public static void main(String[] args) {
    	// 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(9000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "D://aaaa (2).jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));


    }
    
    /**
     * 身份证ocr识别操作
     */
    private static void ocrIdCard(ImageClient imageClient, String bucketName) {
        String ret = null;
        // 1. url方式,识别身份证正面
        System.out.println("====================================================");
        String[] idcardUrlList = new String[2];
        idcardUrlList[0] = "http://youtu.qq.com/app/img/experience/char_general/icon_id_01.jpg";
        idcardUrlList[1] = "http://youtu.qq.com/app/img/experience/char_general/icon_id_02.jpg";
        IdcardDetectRequest idReq = new IdcardDetectRequest(bucketName, idcardUrlList, 0);
        try {
            ret = imageClient.idcardDetect(idReq);
        } catch (AbstractImageException e) {
            e.printStackTrace();
        }
        System.out.println("idcard detect ret:" + ret);
        //识别身份证反面
        idcardUrlList[0] = "https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/314e251f95cad1c89e04bea2763e6709c83d51f3.jpg";
        idcardUrlList[1] = "http://image2.sina.com.cn/dy/c/2004-03-29/U48P1T1D3073262F23DT20040329135445.jpg";
        idReq = new IdcardDetectRequest(bucketName, idcardUrlList, 1);
        try {
            ret = imageClient.idcardDetect(idReq);
        } catch (AbstractImageException e) {
            e.printStackTrace();
        }
        System.out.println("idcard detect ret:" + ret);

        //2. 图片内容方式,识别身份证正面
        System.out.println("====================================================");
        File[] idcardImageList = new File[2];
        idcardImageList[0] = new File("assets", "icon_id_01.jpg");
        idcardImageList[1] = new File("assets", "icon_id_02.jpg");
        idReq = new IdcardDetectRequest(bucketName, idcardImageList, 0);
        try {
            ret = imageClient.idcardDetect(idReq);
        } catch (AbstractImageException e) {
            e.printStackTrace();
        }
        System.out.println("idcard detect ret:" + ret);
        //识别身份证反面
        idcardImageList[0] = new File("assets", "icon_id_03.jpg");
        idcardImageList[1] = new File("assets", "icon_id_04.jpg");
        idReq = new IdcardDetectRequest(bucketName,  idcardImageList, 1);
        try {
            ret = imageClient.idcardDetect(idReq);
        } catch (AbstractImageException e) {
            e.printStackTrace();
        }
        System.out.println("idcard detect ret:" + ret);
    }
}
