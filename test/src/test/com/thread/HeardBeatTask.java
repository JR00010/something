package test.com.thread;

import java.util.TimerTask;

public class HeardBeatTask extends TimerTask {

	@Override
	public void run() {
		
	}
	
	private Boolean isConnection() {
		//...  omit something 
		return  true;
	}
	
	
	private void reConnect() {
		ConnectingTask connectingTask = new  ConnectingTask();
	}

}
