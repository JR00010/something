

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class BaiDu {
    public static void main(String[] args) throws Exception{
    	/*NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);
		double totalMatchCount = 6D;
		double beaseMatchCount = 8D;
		System.err.println((totalMatchCount/beaseMatchCount));
    	AtomicInteger records_num = new AtomicInteger(0);
    	System.err.println(records_num.decrementAndGet());
    	*/
    	/**************************/
//    	Set<GoodsMatchLog> set = new HashSet<GoodsMatchLog>();
//    	GoodsMatchLog c = new GoodsMatchLog();
//    	c.setBno("1231");
//    	c.setCountryCode("H");
//    	c.setCustomType("A");
//    	c.setGoodsCode("45645646");
//    	c.setTableName("aaaa");
//    	c.setName("ASSa");
//    	c.setMatchCount(1l);
//    	GoodsMatchLog c1 = new GoodsMatchLog();
//    	c1.setBno("1231");
//    	c1.setCountryCode("H");
//    	c1.setCustomType("A");
//    	c1.setGoodsCode("45645646");
//    	c1.setTableName("aaaa");
//    	c1.setName("ASSa");
//    	c.setMatchCount(2l);
//    	set.add(c);
//    	set.add(c1);
//    	System.err.println(c.equals(c1));
//    	String s = "Unglazed ceramic flags and paving, includes hearth or wall tiles, whether or not rectangular,the largest surface area of which is capable of being enclosed in a square the side of which is 81cm or more but less than 121 cm, whether or not on a backing, other than those of subheadings 6907.30 and 6907.40, of a water absorption coefficient by weight not exceeding 0.5% but not exceeding 10%";
//    	
//    	
//    	System.err.println(s.length());
//    	
//    	System.err.println("Unglazed".length());
//    	//***********************************************************************************
//    	String s = "sad|dsad|ds";
//    	System.err.println(Arrays.toString(s.split("\\|")));
    	
    	// 提取张三 去除数字
    	
    	
    	/*
    	String s = "dsada %s dsadsa %s";
    	Class classa = GoodsMatchLog.class;
    	Class<?> clazz = GoodsMatchLog.class;// 获取PrivateClass整个类
    	GoodsMatchLog pc = (GoodsMatchLog) clazz.newInstance();// 创建一个实例

		Field[] fs = clazz.getDeclaredFields();// 获取PrivateClass所有属性
		for (int i = 0; i < fs.length; i++) {
			fs[i].setAccessible(true);// 将目标属性设置为可以访问
			System.out.println("赋值前：" + fs[i].getName() + ":" + fs[i].get(pc));
			
			fs[i].set(pc, "null");//将属性值重新赋值
			System.out.println("赋值后：" + fs[i].getName() + ":" + fs[i].get(pc));
		}
		
		Method[] ms = clazz.getDeclaredMethods();// 获取PrivateClass所有的方法
		for (int i = 0; i < ms.length; i++) {
			ms[i].setAccessible(true);// 将目标属性设置为可以访问
			System.out.println("方法 ： " + ms[i].getName());//输出所以方法的名称
		}
		Method m = clazz.getDeclaredMethod("url");
		m.setAccessible(true);
		System.out.println("url方法返回值：" + m.invoke(pc));//得到结果应该是重新赋值后的值null:null
		
		
		*/
//    	GoodsDeclare[] a1 = {};
//    	GoodsDeclare g = new GoodsDeclare();
//    	Class<GoodsDeclare> claszz = (Class<GoodsDeclare>) g.getClass();
//    	Field[] fs = claszz.getDeclaredFields();
//    	for (Field field : fs) {
//    		field.set(g, "特朗普");//将属性值重新赋值
//		}
//    	Person p = new Person();
//    	Class<Person> claszz2 = (Class<Person>)p.getClass();
//    	Field[] fs2 = claszz.getDeclaredFields();
//    	for (Field field : fs2) {
//    		field.set(g, "特朗普");//将属性值重新赋值
//		}
    	
    	Set<String> s = new HashSet<>();
    	System.err.println(s.add("A"));
    	System.err.println(s.add("A"));
    	
    }

    private static String token(String value, String sign) {
        String result = "";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        try {
            FileReader reader = new FileReader("Baidu.js");
            engine.eval(reader);

            if (engine instanceof Invocable) {
                Invocable invoke = (Invocable)engine;
                result = String.valueOf(invoke.invokeFunction("token", value, sign));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    private static String getCode() {
      String s=HttpRequest.sendGet("https://fanyi.baidu.com/", null);
    return  s;
    }
    
    
    class trl{
    	
    }
    
}
