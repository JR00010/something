package test.com.extend;

public class B extends A {
	public String name = "B";
//	public void print() {
//		System.err.println(super.name);
//	}
	public static void main(String[] args) {
		B b = new B();
		System.err.println(b.name);
		b.print();
	}
}
