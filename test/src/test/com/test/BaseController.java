package test.com.test;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface BaseController<T, S> {
	void get(String str);
	 void get2(Consumer<? super T> action);
	 void get3(Supplier<? extends S> supplier);
}
