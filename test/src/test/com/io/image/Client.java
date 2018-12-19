package test.com.io.image;

import java.io.File;
import java.io.IOException;


public class Client {
	public static void main(String[] args) throws IOException {
		String path = (new File("dll")).getCanonicalPath() + File.separator;
//		jn = new JNative(DLL_NAME, "CreateTIFFile");
		System.err.println(path);
	}
}
