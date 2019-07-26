package test.com.queue;

/**
 * @author 80003509
 *
 * @param <P>
 */
public interface Channel<P> {
	
	void put(P Produce) throws InterruptedException;
	P take() throws InterruptedException;
}
