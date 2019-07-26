package test.com.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/** 一个线程多个任务
 * @author 80003509
 *
 */
public class TaskRunner {
	protected final BlockingQueue<Runnable> channel;
	protected volatile Thread workerThread;
	
	public TaskRunner(BlockingQueue<Runnable> channel) {
		this.channel = channel;
	}
	
	public TaskRunner() {
		this(new LinkedBlockingQueue<>());
	}
	
	public void init() {
		Thread t = workerThread;
		if(null !=t) {
			t.start();
		}
	}
	
	public void submit(Runnable tasker) throws InterruptedException {
		channel.put(tasker);
	}
	
	class WorkerThread extends Thread {
		@Override
		public void run() {
			Runnable task = null;
			try {
				for(;;) {
					task = channel.take();
					try {
						task.run();
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			} catch (InterruptedException e) {
				
			}
		}
	}
}
