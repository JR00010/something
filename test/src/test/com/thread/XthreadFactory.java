package test.com.thread;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XthreadFactory implements ThreadFactory {
	private static final Logger l = Logger.getAnonymousLogger();
	private final UncaughtExceptionHandler ueh;
	private final AtomicInteger threadnumber = new AtomicInteger(0);
	private final String namaPrefix;
	

	/**
	 * @param ueh
	 * @param namaPrefix
	 */
	public XthreadFactory(UncaughtExceptionHandler ueh, String namaPrefix) {
		super();
		this.ueh = ueh;
		this.namaPrefix = namaPrefix;
	}
	public XthreadFactory(){
		this(new LogginUncaughtExceptionHandler(), "thread"	);
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = doMakeThread(r);
		t.setName(namaPrefix + "-"+ threadnumber.getAndIncrement());
		t.setUncaughtExceptionHandler(ueh);
		if(t.isDaemon()){ // 是否是守护线程
			t.setDaemon(false);
		}
		if(t.getPriority() !=Thread.NORM_PRIORITY){
			t.setPriority(Thread.NORM_PRIORITY);
		}
		if(l.isLoggable(Level.FINE)){
			l.fine("new thread is created " + t);
		}
		
		return t;
	}
	
	protected Thread  doMakeThread(final Runnable r){
		return new Thread(r){
			@Override
			public String toString() {
				ThreadGroup tg = getThreadGroup();
				String groupName = null == tg ?"":tg.getName();
				String threadInfo = getClass().getSimpleName()+"["+getName() +"-"+ getId() + "-" + groupName +"]"+hashCode();
				return threadInfo;
				
			}
		};
	}
	static class LogginUncaughtExceptionHandler implements UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			l.log(Level.SEVERE,"线程终止： " + e);
		}
		
	}
}
