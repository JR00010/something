package test.com.BeanUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
//import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

public class Client {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		User u =  new User();
		u.setAge(11);
		u.setName("li");
		Map<String, String> m = BeanUtils.describe(u);
		System.err.println(m.toString());
//		BeanUtils.getMappedProperty(u, "name", "s");
//		WrapUser wu = null ;
//		BeanUtils.copyProperties(wu = new WrapUser(), u);
//		System.err.println(wu);
//		System.err.println(BeanUtils.describe(wu));
//		Map<Object, Object> m2 = new BeanMap(u);
//		System.err.println(m2);
		
	}
	
	public static void getData(){
		
	}
}
