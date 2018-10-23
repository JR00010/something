package test.com.classloader;

public class ClassLoaderTest {
	public static void main(String[] args) {
		new ClassLoaderTest().loader();
	}
	private  void loader(){
		ClassLoader c = this.getClass().getClassLoader();
		System.err.println(c.getClass().getSimpleName());
		ClassLoader c2 = c.getParent();
		System.err.println(c2.getClass().getSimpleName());
		System.out.println(System.getProperty("sun.boot.class.path"));
	}
}
