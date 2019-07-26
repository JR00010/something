package test.com.queue;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	public static void main(String[] args) {
		testMap();
	}
	
	
	/**
	 * put 返回的值是原先map中相同key的值 ，不然就返回null
	 * 
	 */
	public static  void testMap() {
		ConcurrentHashMap<String, Integer> m = new ConcurrentHashMap<String, Integer>();
		Integer v1 = m.put("1", 1);
		System.err.println(v1);
		Integer v2 = m.put("1", 2);
		System.err.println(v2);
		System.err.println(m);
	}
}
