package test.com.io;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ShopCar {
	private Myet<Order> order =  new Myet<>();
	
	private class iter<E> implements Iterator<E>{
		private int index;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			return null;
		}
		
	}
	
}
