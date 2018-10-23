package test.com.forcmsp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.apache.ibatis.reflection.invoker.MethodInvoker;
import org.junit.Test;

import test.com.test.ExcelExport;
import test.com.test.Export;
import test.com.test.UserDaoImpl;
import test.com.test.utill.Calculator;

public class Client {
	@Test
	public void client() {
		ArrayList<String> sl = new ArrayList<>();
		sl.add("s");
		sl.add("A");
		Iterator<String> i = sl.iterator();
		ListIterator<String>  lt = sl.listIterator();
		lt.forEachRemaining(X->{
			System.err.println(X);
		});
		while (lt.hasNext()) {
			
			System.err.println(lt.next());
			System.err.println();
		}
	}
	
	@Test
	public void t4(){
		
		InputStream in = this.getClass().getResourceAsStream("test.txt");
		BufferedInputStream bf = new BufferedInputStream(in);
		byte[] b = null;
		try {
			while(bf.read(b)!=1){
				System.err.println(new String(b,"UTF-8"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void t3(){
		try {
			Method d = UserDaoImpl.class.getMethod("getUser", String.class);
			Class c = d.getParameterTypes()[0];
			MethodInvoker d1 = new MethodInvoker(d);
			System.err.println(c.getName());
			System.err.println(d.getReturnType());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		System.err.println(Client.class.getResource("/"));
//		Client c = new Client();
//		InputStream in =c.getClass() .getResourceAsStream("/test.txt");
//		BufferedInputStream bf = new BufferedInputStream(in);
//		byte[] b = new byte[1024];
//		try {
//			while(bf.read(b)!=-1){
//				System.err.println(new String(b,"UTF-8"));
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.err.println(getWaybillNo("SF585","9685135"));
	}
	@Test
	public void testLamada(){
		 Export<ExcelExport> e = new ExcelExport();
		 e.doExport(x->{
			System.err.println(x);
		});
	}
	
	public void Calculator(){
		String expression = "(0*1--3)-5/-4-(3*(-2.13))";
		double result = Calculator.conversion(expression);
		System.out.println(expression + " = " + result);
		System.out.println();
	}
	@Test
	public  void  genCheckCode() {
		String bno = "SF5850096851354";
		String js = bno.substring(5, 14);
		System.err.println(js);
		if (js == null || js.length() != 9)
			return ;
		char CB;
		int P0, P1, P2, P3, P4, P5, P6, P7,P8;
		int A0, A1, A2, A3, A4, A5, A6, A7,A8;
		int Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7,Q8;
		char s0, s1, s2, s3, s4, s5, s6, s7,s8;

		s0 = js.charAt(8);
		s1 = js.charAt(7);
		s2 = js.charAt(6);
		s3 = js.charAt(5);
		s4 = js.charAt(4);
		s5 = js.charAt(3);
		s6 = js.charAt(2);
		s7 = js.charAt(1);
		s8 = js.charAt(0);

		A0 = s0 - '0';
		A1 = s1 - '0';
		A2 = s2 - '0';
		A3 = s3 - '0';
		A4 = s4 - '0';
		A5 = s5 - '0';
		A6 = s6 - '0';
		A7 = s7 - '0';
		A8 = s8 - '0';

		P0 = A0 * 1;
		P1 = A1 * 3;
		P2 = A2 * 5;
		P3 = A3 * 7;
		P4 = A4 * 9;
		P5 = A5 * 11;
		P6 = A6 * 13;
		P7 = A7 * 15;
		P8 = A8 * 17;

		Q0 = (P0 / 10) + (P0 - 10 * (P0 / 10));
		Q1 = (P1 / 10) + (P1 - 10 * (P1 / 10));
		Q2 = (P2 / 10) + (P2 - 10 * (P2 / 10));
		Q3 = (P3 / 10) + (P3 - 10 * (P3 / 10));
		Q4 = (P4 / 10) + (P4 - 10 * (P4 / 10));
		Q5 = (P5 / 10) + (P5 - 10 * (P5 / 10));
		Q6 = (P6 / 10) + (P6 - 10 * (P6 / 10));
		Q7 = (P7 / 10) + (P7 - 10 * (P7 / 10));
		Q8 = (P8 / 10) + (P8 - 10 * (P8 / 10));

		int Q = Q0 + Q1 + Q2 + Q3 + Q4 + Q5 + Q6 + Q7+Q8;
		int m = ((Q / 10) + 1) * 10;
		m = (m - Q) - 10 * ((m - Q) / 10);

		CB = String.valueOf(m).charAt(0);

		System.err.println(CB);
	}
	private static char genCheckCode(String js) {
		if (js == null || js.length() != 9)
			return ' ';
		char CB;
		int P0, P1, P2, P3, P4, P5, P6, P7,P8;
		int A0, A1, A2, A3, A4, A5, A6, A7,A8;
		int Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7,Q8;
		char s0, s1, s2, s3, s4, s5, s6, s7,s8;

		s0 = js.charAt(8);
		s1 = js.charAt(7);
		s2 = js.charAt(6);
		s3 = js.charAt(5);
		s4 = js.charAt(4);
		s5 = js.charAt(3);
		s6 = js.charAt(2);
		s7 = js.charAt(1);
		s8 = js.charAt(0);

		A0 = s0 - '0';
		A1 = s1 - '0';
		A2 = s2 - '0';
		A3 = s3 - '0';
		A4 = s4 - '0';
		A5 = s5 - '0';
		A6 = s6 - '0';
		A7 = s7 - '0';
		A8 = s8 - '0';

		P0 = A0 * 1;
		P1 = A1 * 3;
		P2 = A2 * 5;
		P3 = A3 * 7;
		P4 = A4 * 9;
		P5 = A5 * 11;
		P6 = A6 * 13;
		P7 = A7 * 15;
		P8 = A8 * 17;

		Q0 = (P0 / 10) + (P0 - 10 * (P0 / 10));
		Q1 = (P1 / 10) + (P1 - 10 * (P1 / 10));
		Q2 = (P2 / 10) + (P2 - 10 * (P2 / 10));
		Q3 = (P3 / 10) + (P3 - 10 * (P3 / 10));
		Q4 = (P4 / 10) + (P4 - 10 * (P4 / 10));
		Q5 = (P5 / 10) + (P5 - 10 * (P5 / 10));
		Q6 = (P6 / 10) + (P6 - 10 * (P6 / 10));
		Q7 = (P7 / 10) + (P7 - 10 * (P7 / 10));
		Q8 = (P8 / 10) + (P8 - 10 * (P8 / 10));

		int Q = Q0 + Q1 + Q2 + Q3 + Q4 + Q5 + Q6 + Q7+Q8;
		int m = ((Q / 10) + 1) * 10;
		m = (m - Q) - 10 * ((m - Q) / 10);

		CB = String.valueOf(m).charAt(0);

		return CB;
	}
	public static  String getWaybillNo(String suffix, String billSeq) {
		int len = billSeq.length();
		// 不足8位,前面补0
		if (len < 9) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 9 - len; i++) {
				builder.append("0");
			}
			builder.append(billSeq);
			billSeq = builder.toString();
		}
		return new StringBuilder().append(suffix).append(billSeq)
				.append(genCheckCode(billSeq)).toString();
	}
	
	
}
