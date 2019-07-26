package test.com.thread;

import java.util.Timer;

import javax.swing.text.html.HTMLDocument.BlockElement;

import org.apache.commons.collections.Predicate;
/**
 * 保护性暂挂模式。
 */
public class Alarmagent {
	private volatile Boolean connectedToServer = false;
	
	private  final  Predicate predicate = new Predicate() {
		@Override
		public boolean evaluate(Object object) {
			return connectedToServer;
		};
	};
	
	private final  Blocker b  = new ConnectionVarBlocker();
	
	private final Timer hreadBeatTimer = new Timer(true);
	
	
	public void sendAlarm(final AlaimInfo alarm) {
		
	}
	
}
