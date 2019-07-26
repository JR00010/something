package test.com.collection;
import java.util.*;
public class MyClass {
	int count;
	int accumulated;
	public MyClass() {
	}
	public void record(int v) {
		count++;
		accumulated += v;
	}
	public int average() {
		return accumulated / count;
	}
	
}