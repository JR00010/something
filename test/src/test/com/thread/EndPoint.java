package test.com.thread;

/**
 * 表示下游部件的节点
 * @author 80003509
 *
 */
public class EndPoint {
	public final String host;
	public final int  port;
	public final int weight;
	private volatile Boolean online = true;
	
	public EndPoint(String  host, int port, int weight ) {
		this.host = host ;
		this.port = port;
		this.weight = weight;
	}

	public Boolean getOnline() {
		return online;
	}

	/**  
	 * @param online
	 */
	public void setOnline(Boolean online) {
		this.online = online;
	}
}
