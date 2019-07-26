package test.com.io.image;

import java.io.File;
import java.io.IOException;

import com.qcloud.image.ImageClient;
import com.qcloud.image.common_utils.CommonFileUtils;
import com.qcloud.image.request.IdcardDetectRequest;


public class Client {
	public static void main(String[] args) throws IOException {
		String path = (new File("dll")).getCanonicalPath() + File.separator;
//		jn = new JNative(DLL_NAME, "CreateTIFFile");
		System.err.println(path);
	}
}


