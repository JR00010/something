package test.com.thread;

import java.util.Iterator;
import java.util.Set;

/**
 * 
 *  不可变对象 负载均衡器。
 * @author 80003509
 *
 */
public final  class CandiData implements Iterable<String> {
	
	private final Set<String> en;
	private final int weight;
	
	public  CandiData(Set<String> en) {
		this.en = en;
		this.weight  = 0;
	}
	@Override
	public Iterator<String> iterator() {
		return null;
	}
}
