package test.com.queue;

import java.util.concurrent.ArrayBlockingQueue;

/** 有节队列是否会引起 线程的等待
 * @author 80003509
 * 
 * ArrayBlockingQueue 中有两个方法添加元素 。Add 不会造成线程阻塞，在元素add不进去的时候 直接爆出异常。put方法会 ，造成线程等待
 * 
 *
 */
public class ArrayBlockQueueDemo {
	public static void main(String[] args) {
		ArrayBlockingQueue<String> array =  new ArrayBlockingQueue<String>(3);

		new Thread(new ArrayBlockPutTasck(array)).start();
		new Thread(new ArrayBlockTakeTasck(array)).start();
	}
}
class ArrayBlockTakeTasck implements Runnable {
	final ArrayBlockingQueue<String> array;


	public ArrayBlockTakeTasck(ArrayBlockingQueue<String> array) {
		super();
		this.array = array;
		
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			
			try {
				array.add(array.take());
				System.err.println(Thread.currentThread().getName()+"---take--"+ array.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class  ArrayBlockPutTasck implements Runnable{
	final ArrayBlockingQueue<String> array;

	public ArrayBlockPutTasck(ArrayBlockingQueue<String> array) {
		super();
		this.array = array;
	}

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.err.println(Thread.currentThread().getName()+"------"+ i);
			try {
				array.put(i+"");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}