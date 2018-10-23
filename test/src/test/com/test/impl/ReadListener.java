package test.com.test.impl;

import test.com.Event;
import test.com.test.interfacet.Listener;

public class ReadListener implements Listener
{
	@Override
	public void isReading(Event event) 
	{
		 System.out.println("正在读书...");
	}
}