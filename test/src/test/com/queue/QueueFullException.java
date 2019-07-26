package test.com.queue;

/**
 * @author 80003509
 *
 */
public class QueueFullException extends Exception {
//	private String exString;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueueFullException(String exString) {
		super(exString);
//		this.exString = exString;
	}
	
}
