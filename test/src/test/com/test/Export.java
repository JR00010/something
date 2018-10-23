package test.com.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Consumer;

import test.com.test.utill.GenericsUtils;

public class Export<T> {
	 public void doExport(Consumer<T> action){
		Class s = GenericsUtils.getSuperClassGenricType(this.getClass());
		T t =null;
		try {
			t = (T) s.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 action.accept(t);
	};
}
