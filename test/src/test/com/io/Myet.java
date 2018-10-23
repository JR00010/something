package test.com.io;

import java.util.HashSet;
import java.util.Iterator;

public class Myet<E> implements Iterator<E>{
	public void  remove(Object o) throws Exception {
			throw new Exception("不能删除");
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public E next() {
		return null;
	}
}
