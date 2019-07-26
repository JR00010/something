package test.com.queue;
import java.util.Iterator;

 
/** 环形队列 数组 实现
 * @author 80003509
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class CircleQueue2<T> {
	private final  T[] array;
	private  int  front= 0; // 头
	private  int tail = 0; //要添加的元素的位置
	
	private  int capacity = 16;

	public  CircleQueue2(){
		this(16);
	}
	public  CircleQueue2(int capacity){
		this.capacity = capacity;
		this.array = (T[]) new Object[capacity];
	}
	public void add(T element) throws QueueFullException {
		if(front ==  tail%capacity && array[front] != null ) {
			throw new QueueFullException("queue out of  index ");
		}
		array[tail++] = (T) element;
		tail = tail%capacity;
	}
//	public void add(T element, int index) throws QueueFullException {
//		if()
//		if(index>front&& index<tail)
//		tail = index;
//		add(element);
//	}
	
	public  T remove(T element) throws QueueFullException {
		if(front ==  tail && array[front] == null) {
			throw new QueueFullException("queue is empity ");
		}
		T t  = array[front++];
		front = front%capacity;
		return  t;
	}
	
	public Iterator<T> interrator() {
		return new circleQueueIterator();
	}
    private class circleQueueIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return front !=  tail;
        }
 
        @Override
        public T next() {
            return array[tail] ;
        }
    }
}
