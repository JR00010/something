package test.com.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**  LinkedBlockingQueue  链表阻塞队列  
 *  	add   在超出队列长度的时候 会抛出异常   remove：队列为空的时候会爆出异常
 *  	put   在超出队列长度的时候 ，线程阻塞 ，等待队列有新的插入空间
 *  	offer 在超出队列长度的时候 ，插入失败会返回布尔值 false
 *  	对比ArrayBlockQueue 这个队列链表的增加删除快 ，但是对于 垃圾回收来说是个负担。
 *  
 *  	contains方法和size 方法都是遍历颞部节点 ，数据大需要注意性能问题。
 * @author 80003509
 *
 */
public class LinkBlockQueueDemo {
	
		public static void main(String[] args) {
			LinkedBlockingQueue<String> queue  = new LinkedBlockingQueue<>(3);
			new Thread(new PutTasck(queue)).start();
			new Thread(new TakeTasck(queue)).start();
		}
}


class  PutTasck implements Runnable{
	final LinkedBlockingQueue<String> queue ;
	int  i = 0;
	public PutTasck (LinkedBlockingQueue<String> queue) {
		this.queue  = queue ;
	}
	@Override
	public void run() {
		while (true) {
//			try {
				queue.add(Thread.currentThread().getName());
				System.err.println(Thread.currentThread().getName() + "queue put  thead name :      " + ++i);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
		}
	}
	
}
class  TakeTasck implements Runnable{
	final LinkedBlockingQueue<String> queue ;
	public TakeTasck  (LinkedBlockingQueue<String> queue ) {
		this.queue = queue ;
	}
	@Override
	public void run() {
		while (true) {
			try {
				System.err.println(Thread.currentThread().getName() + " queue take the element is :   " + queue.take());
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}