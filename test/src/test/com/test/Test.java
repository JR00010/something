package test.com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.swing.plaf.synth.SynthStyle;

public class Test {
	public static void main(String[] args) {
//		System.err.println(ResourceBundle.getBundle("test.txt").getString("1"));
//		System.err.println(String.format("{}131", 5));
		 String str=null;
		  	String s = "下载数量超过%s------%s,禁止下载";
		    str=String.format(s, 300,3000);          // 格式化字符串

		    System.out.println(str);                             // 输出字符串变量str的内容

		    System.out.printf("字母a的大写是：%c %n", 'A');

		    System.out.printf("3>7的结果是：%b %n", 3>7);

		    System.out.printf("100的一半是：%d %n", 100/2);

		    System.out.printf("100的16进制数是：%x %n", 100);

		    System.out.printf("100的8进制数是：%o %n", 100);

		    System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);

		    System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);

		    System.out.printf("上面价格的指数表示：%e %n", 50*0.85);

		    System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);

		    System.out.printf("上面的折扣是%d%% %n", 85);

		    System.out.printf("字母A的散列码是：%h %n", 'A');
		    
//		    ---------------------------------------------
		    String[] atp = {"Rafael Nadal", "Novak Djokovic",  
		    	       "Stanislas Wawrinka",  
		    	       "David Ferrer","Roger Federer",  
		    	       "Andy Murray","Tomas Berdych",  
		    	       "Juan Martin Del Potro"};  
		    	List<String> players =  Arrays.asList(atp);  
		    	  
		    	// 以前的循环方式  
//		    	for (String player : players) {  
//		    	     System.out.print(player + "; ");  
//		    	}  
//		    	  
		    	// 使用 lambda 表达式以及函数操作(functional operation)  
//		    	players.forEach((player) -> System.out.print(player + "; "));  
		    	   
		    	// 在 Java 8 中使用双冒号操作符(double colon operator)  
		    	players.forEach(System.out::println);
		    	int i = -1>>1;
		    	System.err.println(i);
		    	Set<String> ss = new HashSet<>();
		    	ss.add("a");
		    	ss.add("b");
		    	String aaa = "1231,";
		    
		    	System.err.println(aaa.format("YYY-YYY", "----"));
		    	
		    	Predicate<M> p = new Predicate<M>() {
					
					@Override
					public boolean test(M t) {
						// TODO Auto-generated method stub
						return false;
					}
				};
				
//				ter(new It());
		BaseController<Test,Integer> b = new BaseController<Test,Integer>() {

			@Override
			public void get(String str) {
				
			}

			@Override
			public void get2(Consumer<? super Test> action) {
				action.accept(new Test());
			}

			@Override
			public void get3(Supplier<? extends Integer> supplier) {
				// TODO Auto-generated method stub
				
			}
		};
		b.get2(x->{
			System.err.println(x);
			Test.get("----");
		});
//		Objects.requireNonNull(b,x->{});
//				ter1(x->{
//					System.err.println(x);
//				});
		StringBuilder sb = new StringBuilder(200);
		sb.append("短信模板：尊敬的客户，您好！您的运单号XXXXXXXXXXXX，经厦门办理通关手续"
				+ "，为了有效保护您的身份信息仅被您本人使用，厦门海关推行“互联网+身份认证”监管要求，故需您下载单一窗口身份验证APP进行认证，app下载网址：http://t.cn/RdV5pJr，请按相关指引向海关提交个人身份电子信息（网址：http://t.cn/RDiHuwl）。如有疑问，可拨打顺丰关务客服热线0592-5651092咨询，谢谢！温馨提醒：如您使用苹果手机，安装完成后，请打开设置-通用-设备管理-点击企业级应用-Tendyron Corporation-信任");
		System.err.println(sb.toString());
		getLength("短信模板：尊敬的客户，您好！您的运单号XXXXXXXXXXXX，经厦门办理通关手续，为了有效保护您的身份信息仅被您本人使用，厦门海关推行“互联网+身份认证”监管要求，故需您下载单一窗口身份验证APP进行认证，app下载网址：http://t.cn/RdV5pJr，请按相关指引向海关提交个人身份电子信息（网址：http://t.cn/RDiHuwl）。如有疑问，可拨打顺丰关务客服热线0592-5651092咨询，谢谢！温馨提醒：如您使用苹果手机，安装完成后，请打开设置-通用-设备管理-点击企业级应用-Tendyron Corporation-信任");
		System.out.println("--------------------");
//		if(isSendSuccess(1))
//			System.err.println(isSendSuccess(1));
//		if(isSendSuccess(2))
//			System.err.println("666");
//		System.err.println("*****");
		System.out.println("--------------------");
		 Export<ExcelExport> e = new ExcelExport();
		e.doExport(x->{
			System.err.println(x);
		});
	}
	public static  Boolean isSendSuccess(int i) {
		if (i==1) {
			return true;
		}
		throw new RuntimeException("短信未发送");
	}
	static void get(String s){
		System.err.println(s.getClass().getName());
	}
//	static <T> Boolean isnull(Predicate<T> p){
//		List<String> al = Arrays.asList("a", "b", "c", "d");
//		al.forEach(Test::get);
//		return null;
//	}
	
//	public static void ter(It i){
//		Consumer<String> methodParam= Test::get;
//		i.sert(Test::get);
//	}
	public static void ter1(BaseController i){
	}
	
	
	public static  int getLength(String str){
		System.err.println(str.length());
		return str.length();
	}
}
