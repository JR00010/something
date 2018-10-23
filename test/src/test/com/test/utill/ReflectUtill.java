package test.com.test.utill;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectUtill {
    public static  Class<?>  getMyClass(Class<?> cz){
        //class com.dfsj.generic.UserDaoImpl因为是该类调用的该法，所以this代表它

        //返回表示此 Class 所表示的实体类的 直接父类 的 Type。注意，是直接父类
        //这里type结果是 com.dfsj.generic.GetInstanceUtil<com.dfsj.generic.User>
        Type type = cz.getGenericSuperclass();

        // 判断 是否泛型
        if (type instanceof ParameterizedType) {
            // 返回表示此类型实际类型参数的Type对象的数组.
            // 当有多个泛型类时，数组的长度就不是1了
            Type[] ptype = ((ParameterizedType) type).getActualTypeArguments();
            return (Class) ptype[0];  //将第一个泛型T对应的类返回（这里只有一个）
        } else {
            return Object.class;//若没有给定泛型，则返回Object类
        }

    }
    public Boolean isA(Object a, Object b){
    	return isA(a.getClass(),b.getClass());
    }
    
    public Boolean isA(Class<?> a, Class<?> b) {
    	if (a.isAssignableFrom(b)) {
			return true;
		}
    	return false;
    }
}
