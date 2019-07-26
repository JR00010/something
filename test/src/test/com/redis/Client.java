package test.com.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class Client {
	public static void main(String[] args) {
		System.out.println("----------------Tests main-----------------");
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.set("ws1", "1");
        jedis.set("ws2", "2");
        jedis.set("ws3", "3");

        Set<String> keys = jedis.keys("ws*");

        System.out.println(keys);

        for (String key : keys) {
        	System.err.println(jedis.get(key));
//            jedis.del(key);
        }
        
        System.out.println(jedis.keys("ws*"));

	}
}
