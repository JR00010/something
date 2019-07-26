package test.com.bean;

public class Student extends Person {
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return super.toString() + "Student [className=" + className + "]";
	}
	
}
