package test.com.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class Client {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", null);
//		map.put("age", null);
		map.put("ds", "44");
		List<String> ll = new ArrayList<>();
		map.put("LI", ll);
		User u = JSON.parseObject(JSON.toJSONString(map), User.class);
		System.err.println(u.toString());
	}
}
