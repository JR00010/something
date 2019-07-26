package test.com.extend;

public class A {
	public String name = "A";
	
	public void print() {
		System.err.println(this);
		System.err.println(this.name);
	}

	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}
	
}
