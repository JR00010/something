package test.com.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

import test.com.queue.Channel;

/** Semaphore 的acquire 和 release（） 总在一块使用
 * @author 80003509
 *
 * @param <P>
 */
public class SemahporeBaseChannel<P> implements Channel<P>{
	private final BlockingDeque<P> queue;
	private final Semaphore semaphore;
	public  SemahporeBaseChannel(BlockingDeque<P> queue, int flowLimit) {
		this(queue, flowLimit,false);
	}
	public  SemahporeBaseChannel(BlockingDeque<P> queue, int flowLimit,Boolean isFair) {
		this.queue = queue ;
		this.semaphore = new Semaphore(flowLimit, isFair);
	}
	@Override
	public void put(P Produce) throws InterruptedException {
		semaphore.acquire();
		try {
			queue.put(Produce);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		}
		
	}

	@Override
	public P take() throws InterruptedException {
		return queue.take();
	}

}
