package test.com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;



public class ClassUtil{

	/**
	 * 是否为标准的类
	 * 这个类必须：
	 * 1、非接口 
	 * 2、非抽象类 
	 * 3、非Enum枚举 
	 * 4、非数组 
	 * 5、非注解 
	 * 6、非原始类型（int, long等）
	 * @param clazz 类
	 * @return 是否为标准类
	 */
	public static boolean isNormalClass(Class<?> clazz) {
		return null != clazz //
				&& false == clazz.isInterface() //
				&& false == isAbstract(clazz) //
				&& false == clazz.isEnum() //
				&& false == clazz.isArray() //
				&& false == clazz.isAnnotation() //
				&& false == clazz.isSynthetic() //
				&& false == clazz.isPrimitive();//
	}
	/**
	 * 是否为抽象类
	 * 
	 * @param clazz 类
	 * @return 是否为抽象类
	 */
	public static boolean isAbstract(Class<?> clazz) {
		return Modifier.isAbstract(clazz.getModifiers());
	}
	
	/**
	 *  获取类方法 ，忽略大小写 ，包括继承的前三个父类（如果有继承）
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * 
	 */
	public static Method  getDMethodS(Class<?> clazz,String MethodName) throws NoSuchMethodException, SecurityException {
		Method method = null;
		try {
			method = getDMethod(clazz,MethodName);
			//method = clazz.getDeclaredMethod(MethodName);
		}catch (Exception e) {
			Class<?> classSup = clazz.getSuperclass();
			try {
				method = getDMethod(classSup,MethodName);
			}catch (Exception e1) {
				Class<?> classSupII = classSup.getSuperclass();
				try {
					method = getDMethod(classSupII,MethodName);
				}catch (Exception e2) {
					throw e2;
				}
			}
		}
		return method;
	}
	
	public static  Field getDFieldS(Class<?> clazz,String fieldName) throws NoSuchMethodException, SecurityException {
		Field method = null;
		try {
			method = getDField(clazz,fieldName);
		}catch (Exception e) {
			Class<?> classSup = clazz.getSuperclass();
			try {
				method = getDField(classSup,fieldName);
			}catch (Exception e1) {
				Class<?> classSupII = classSup.getSuperclass();
				try {
					method = getDField(classSupII,fieldName);
				}catch (Exception e2) {
					return null;
				}
			}
		}
		return method;
	}
	
	public static  Field getDField(Class<?> clazz,String fieldName) throws NoSuchMethodException, SecurityException {
		Field[] fs = clazz.getDeclaredFields();
		for (int i = 0; i <fs.length; i++) {
			if(Objects.equals(fieldName.toLowerCase(), fs[i].getName().toLowerCase())) {
				return  fs[i];
			}
		}
		throw new NoSuchMethodException();
	}
	/** 获取类方法 ，忽略大小写
	 * @param clazz
	 * @param MethodName
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static  Method getDMethod(Class<?> clazz,String MethodName) throws NoSuchMethodException, SecurityException {
		Method[] mhs = clazz.getDeclaredMethods();
		for (int i = 0; i < mhs.length; i++) {
			if(Objects.equals(MethodName.toLowerCase(), mhs[i].getName().toLowerCase())) {
				return  mhs[i];
			}
		}
		throw new NoSuchMethodException();
	}
	@SuppressWarnings("unchecked")
	public static <T> T getGenericityEntry(Class<?> clazz) throws InstantiationException, IllegalAccessException{
	   Type genType = clazz.getGenericSuperclass();  
	   Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
	   Class<T> entityClass = (Class<T>) params[0];  
	   
	   return entityClass.newInstance();
	}
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericityClass(Class<?> clazz) throws InstantiationException, IllegalAccessException{
	   Type genType = clazz.getGenericSuperclass();  
	   Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
	   Class<T> entityClass = (Class<T>) params[0];  
	   
	   return entityClass;
	}
}