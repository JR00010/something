package test.com.classloader;

public class PathClassLoader extends ClassLoader{
	private String classPath;
	public PathClassLoader(String classPath){
		this.classPath = classPath;
	}
	protected Class<?> findClass(String name) {
		if(pakegeName.startWith(name)	{
			
		})
		return null;
	}
}
