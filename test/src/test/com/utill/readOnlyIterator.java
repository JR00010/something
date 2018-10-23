package test.com.utill;

import java.util.Iterator;

public class readOnlyIterator<E> implements Iterator<E> {
	Iterator<E> iter  ;
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		
		return iter.next();
	}
	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove");
	}

}
