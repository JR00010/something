package test.com.thread;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2015-10-23 下午01:47:03 类说明
 */
public class TestLock
{
    // @Test
    public void test() throws Exception
    {
        final Lock lock = new ReentrantLock();
        lock.lock();

        
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
            	System.out.println("子线程获取锁：0");
                try {
					lock.tryLock(1500, TimeUnit.MICROSECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//            	try {
////					lock.lockInterruptibly();
//            		Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					System.err.println("捕获异常");
//				}
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        },"child thread -1");
        
        t1.start();
//        Thread.sleep(1000);
        TimeUnit.SECONDS.sleep( 1 );
        System.err.println("睡觉1000");
//        t1.interrupt();
        
        Thread.sleep(10_000);
        lock.unlock();
        System.out.println("主线程跑完...");
    }
    
    public static void main(String[] args) throws Exception
    {
        new TestLock().test();
    }
}
