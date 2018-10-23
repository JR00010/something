package test.com.test;

import java.util.function.Consumer;

public class It {
	<T> void sert(Consumer<? super T> action) {
		System.err.println(action);
	}
}
