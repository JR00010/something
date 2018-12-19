package test.com.zhengzebiaodashi;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Client {
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("^[0-9]{12}|^[A-Za-z]{2}[0-9]{13}$");
		System.err.println(p.matcher("SF1236352152596").matches());
		System.err.println("dd56".matches("^[A-Za-z]{2}[0-9]{1}$"));
		String s = "070036987522,856230644535,856230647555256asasas";
		String[] sw= s.split("\n", s.length());
		System.err.println(Arrays.toString(sw));
		
		System.err.println("sf1236352152596".matches("^(SF|sf|[0-9])[0-9]*"));
	}
}
