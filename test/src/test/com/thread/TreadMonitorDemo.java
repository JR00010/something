package test.com.thread;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;


/**
 * 线程意外 中断，重启开启另一个线程 继续 执行没有完成的任务
 * 
 * @author 80003509
 *
 */
public class TreadMonitorDemo {
	volatile Boolean inited = false;
	static int threadIndex = 0;
	final static Logger l = Logger.getAnonymousLogger();
	final BlockingQueue<String> channal = new ArrayBlockingQueue<String>(100);
	public static void main(String[] args) throws InterruptedException {
		TreadMonitorDemo demo = new TreadMonitorDemo();
		demo.init();
		for (int i = 0; i < 100; i++) {
			demo.servce("t-"+i);
		}
	}
	
	private void servce(String string) throws InterruptedException {
		channal.put(string);
	}

	public synchronized void init(){
		if (inited) {
			return ;
		}
		WokrerThread  t = new WokrerThread();
		t.setName("Workrer-"+threadIndex++);
		t.setUncaughtExceptionHandler(new ThreadMonitor());
		t.start();
		inited = true;
	}
	private class ThreadMonitor implements Thread.UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			String name = t.getName();
			System.err.println("线程中断"+name);
			inited = false;
			init();
		}
		
	}
	
	private class WokrerThread extends Thread{
		@Override
		public void run() {
			String msg ; 
			try{
				for(;;){
					msg = channal.take();
					process(msg);
				}
			}catch(InterruptedException e){
				
			}
		}

		private void process(String msg) {
			System.err.println(msg);
			if((Math.random()*100)<2){
				throw new RuntimeException("随机异常");
			}
		}
	}
}
