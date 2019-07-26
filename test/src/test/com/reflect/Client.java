package test.com.reflect;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;

import cn.hutool.core.map.MapUtil;
import cn.hutool.script.ScriptRuntimeException;
import cn.hutool.script.ScriptUtil;

import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.CompiledScript;
import javax.script.ScriptException;

import java.util.Objects;

import test.com.BeanUtil.User;
import test.com.bean.Area;
import test.com.bean.Person;
import test.com.bean.Student;
import test.com.utill.StringUtil;

public class Client {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		try {
			Class<?> classzz = Client.class.getClassLoader().loadClass("test.com.reflect.Laser");
//			Class<?> classzz = Client.class.forName("test.com.reflect.Laser");
			Laser obj = (Laser)classzz.newInstance();
			obj.console();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] srt = {"1","3","9"};
		System.err.println(Arrays.toString(Arrays.copyOf(srt, srt.length + 1)));
		String[] srtw = new String[srt.length + 1];
		
		System.arraycopy(srt, 0, srtw, 0, 2);
//		System.arraycopy(srt, 2, srtw, 2 + 1,
//				srt.length-2);
		System.err.println(Arrays.toString(srtw));
		
		Student p1 = new Student();
		p1.setId("1");
		p1.setName("文雨");
		p1.setClassName("666");
		Area ds = new Area();
		ds.setCode("003");
		ds.setName("郴州");
		p1.setArea(ds);
		p1.setAge(6);
//		System.err.println(p1.toString());
//		getBLog(Person.class,"",p1,p1);
		
//		int[] ds = new int[10] ;
//		for (int i = 0; i < 10; i++) {
//			ds[i] = i;
//		}
//		System.err.println(toSqlClause(ds));
		
//		Class<?> c = p1.getClass();
//		Field[] fs = c.getDeclaredFields();
//		
//		for (int i = 0; i < fs.length; i++) {
//			String name = fs[i].getName();
//			String methedName = "get" + name.replace(name.charAt(0),(char)(name.charAt(0) - 32));
//			System.err.println(methedName);
//			fs[i].setAccessible(true);
//			System.err.println(fs[i].getName());
//			System.err.println(fs[i].get(p1));
//		}
		
	//	System.err.println("ASD".contains("A"));
		
		String rs = objToStr(p1,newMap("{'id':'主键','age':'年龄','name':'姓名','className':'班级','area':{'code':'代码','name':'地名'},'strs':'发大发'} "),"倒计时了的是");
		System.err.println(rs);
		
		
		//System.err.println(filterMatchName2("大萨达  发送   10%"));
//		
//		
//		CompiledScript script = ScriptUtil.compile("var a = 1; print(a)");
//		try {
//		    script.eval();
//		} catch (ScriptException e) {
//		    throw new ScriptRuntimeException(e);
//		}
		//getSql();
	}
	public static String toSqlClause (int[] ids) {
		StringBuilder sb  =  new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			sb.append(sb.length() == 0?ids[i]:", "+ids[i]);
			if(i%5 == 0 && i != 0 ) {
				sb.append(") or id in (");
			}
		}
		sb.insert(0, "id in (");
		sb.append(")");
		return sb.toString().replace("(,", "(");
	}
	public static  <T> User getBLog(Class<T> classzz ,String operate, T o, T n) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Method m = classzz.getDeclaredMethod("getId");
		
		Method m2 = classzz.getDeclaredMethod("createTime");
		
		Object sd = m.invoke(o);
		return null;
	}
	private static String  objToStr(Object o,Map<String, Object> fieldsMap,String TbName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	
    	StringBuilder rs = new StringBuilder();
    	jiontPorp(o, fieldsMap,rs);
    	rs.insert(0,"[");
    	rs.insert(0,TbName);
    	rs.replace(rs.length()-2, rs.length(), "]");
    	return rs.toString();
    }
	
	
	private static void jiontPorp(Object o,Map<String, Object> fieldsMap,StringBuilder sb) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Set<Entry<String, Object>> set = fieldsMap.entrySet();
    	for (Entry<String, Object> entry : set) {
    		String FiledName = entry.getKey();
    		Object v = entry.getValue();
    		
    		String methedName = "get" + FiledName.replace(FiledName.charAt(0),(char)(FiledName.charAt(0) - 32));
    		Method m = ClassUtil.getDMethodS(o.getClass(), methedName);
    		Object obj = m.invoke(o);
    		obj = null == obj ? "" : obj;
    		if(v instanceof Map) {
    			jiontPorp(obj,(Map<String, Object>)v,sb);
    		}else {
    			if( obj instanceof Object[]) {
    				sb.append(v).append("=").append("'").append(Arrays.toString((Object[])obj)).append("'").append(", ");
    			}else {
    				sb.append(v).append("=").append("'").append(obj.toString()).append("'").append(", ");
    			}
    		}
    		
		}
    	
    }
	private static Map<String, Object> newMap(String txt){
		final String  t = txt;
		com.alibaba.fastjson.JSONObject dasf = com.alibaba.fastjson.JSONObject.parseObject(txt);
		
		Set<String> ds = (Set<String>)dasf.keySet();
		String[] s = new String[ds.size()];
		String[] arr = ds.toArray(s);
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(t.indexOf(o1)> t.indexOf(o2)) {
					return 1;
				}
				if(t.indexOf(o1)< t.indexOf(o2)) {
					return -1;
				}
				return 0;
			}
		});
		
		LinkedHashMap<String, Object> lin = new LinkedHashMap<>();
		for (int i = 0; i < arr.length; i++) {
			lin.put(arr[i], dasf.get(arr[i]));
		}
		return lin;
	}
	
	
	private static  String filterMatchName2(String gdesc){
		Pattern p = Pattern.compile("([0-9.]+[%])");
		Matcher matcher= p.matcher(gdesc);
		gdesc = matcher.replaceAll("");

		p = Pattern.compile("([([\\s]*)`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}\\\\【】‘；：”“’。，、？])");
		matcher= p.matcher(gdesc);
		gdesc = matcher.replaceAll("");

		return gdesc;
	}
	
	
	private static void  getSql() {
		long  num = 13128958020l;
		String Bno = "'SF6143000224796','425845821806','SF6143000224557','425085185724','425970263162','SF6143000223729','SF6141000031632','SF1010291993913','425872828316','SF6143000223862','SF1010291993931','971785522652','373368551723','SF1010291994529','SF1010297912654','SF1010297895822','SF6143000223853','756635719526','SF1010291993631','261287852657','425110661752','787311433847','425473182662','SF1010291993659','425478542909','SF6143000224496','425569781947','SF6143000223987','425171171014','033111512205','SF1010298213010','SF1010297911880','SF1010291994283','425663415777','SF6143000223738','425224241935','964785275376','SF6143000224487','SF6143000223969','SF6143000224609','425455150882','425050227740','SF1010291992336','SF1010291994538','SF6143000224539','SF6143000223669','425109086190','SF6143000224723','425041851027','SF6143000223950','SF1010298205308','SF6143000223701','425599329549','SF6143000224520','425907613042','425130688714','425627423982','SF1010297898164','SF6143000223844','SF1010291994495','425911420985','SF1010298199228','SF1010291993861','425158604185','SF6143000223899','SF6143000223932','SF6143000224502','SF6143000223774','425243009342','425188266476','SF6143000223747','SF6143000223835','SF6143000223923','SF6143000223687','SF1010291993613','SF1010291994501','440244575861','SF6143000224778','SF1010291994565','425661922036','SF6143000223678','SF6143000224732','425218854354','425282692813','033279990657','425515902192','SF6143000224811','425416958722','SF6143000224114','SF6143000224636','425022428204','033285824256','SF6143000224618','SF6143000224741','425816463001','SF1010291994556','SF1010291993640','SF1010291993940','425275479607','SF1010291993959','SF6143000224584','425547066557','SF1010298193991','425963077452','425132570325','SF6143000224593','SF1010297898298','425241162109','425741394246','SF6143000224750','SF6143000223905','SF6143000224478','SF6143000223941','425456612004','033510658182','SF6143000224714','SF6143000224575','425910278075','SF6143000224769','SF6143000224548','425803950290','SF6143000224705','SF1010291994477','SF6143000224566','425316243568','608024005529','425308143277','425628628858','425487078009','SF6143000224802','SF6143000223978','SF6143000223996';";
		String[] bs = Bno.split(",");
		String tp = "UPDATE tm_original_data\r\n" + 
				"SET TEL = '%d',\r\n" + 
				" MOBILE = '%d'\r\n" + 
				"WHERE  BNO = %s;";
		StringBuilder sql = new StringBuilder();
		for (String string : bs) {
			
			sql.append(String.format(tp,num, num,string));
			num++;
		}
		System.err.println(sql);
	}
}
