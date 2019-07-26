package test.com.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

public class MySerializer  implements Serializer<String>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(String topic, String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
