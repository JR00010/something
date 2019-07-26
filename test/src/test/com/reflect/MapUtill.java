package test.com.reflect;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class MapUtill {
	public static void main(String[] args) {
		Map<Object,Object> map1 = newMap("{'id':'主键','age':'年龄','name':'姓名','className':'班级','area':{'code':'代码','name':'地名','as':'的'},'strs':'发大发'} ",true);
		System.err.println(map1);
		// --------------------------------------------------------------------------------
		Map<Integer,String> map = new HashMap<>();
		map.put(2342, "a1");
		map.put(1231, "a2");
		map.put(24355, "a3");
		map.put(123, "a4");
		System.err.println(map);
		// --------------------------------------------------------------------------------
		Object[] arr = sortKeysArray(map,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}

		});
		System.err.println(Arrays.toString(arr));
		// --------------------------------------------------------------------------------
		Set<Integer> set = sortKeysSet(map,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}

		});
		System.err.println(set);
		// --------------------------------------------------------------------------------
		List<Integer> list = sortKeysList(map,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}

		});
		System.err.println(list);
		
	}
	/** 返回一个按添加顺序存放的map
	 * @return
	 */
	public static <V, K> Map<K,V> newMap(){
		return new LinkedHashMap<K,V>();
	}
	
	public static Map<Object,Object> newMap(String txt){
		return newMap(txt,false);
	}
	
	/**
	 * @param txt Map字符串
	 * @param sort 是否按txt 排序生成
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static  Map<Object,Object> newMap(String txt,Boolean sort){
		com.alibaba.fastjson.JSONObject jsonObj = com.alibaba.fastjson.JSONObject.parseObject(txt);
		if(!sort) {
			return (Map)jsonObj;
		}
		final String  t = txt;
//		Map<String, Object> rs = sort(jsonObj,new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				if(t.indexOf(o1)> t.indexOf(o2)) {
//					return 1;
//				}
//				if(t.indexOf(o1)< t.indexOf(o2)) {
//					return -1;
//				}
//				return 0;
//			}
//		});
		
		Object[] arrKeys = sortKeysArray((Map)jsonObj,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(t.indexOf(o1)> t.indexOf(o2)) {
					return 1;
				}
				if(t.indexOf(o1)< t.indexOf(o2)) {
					return -1;
				}
				return 0;
			}
		});
		
		Map<String, Object> rs = newMap();
		for (int i = 0; i < arrKeys.length; i++) {
			Object v = jsonObj.get(arrKeys[i]);
			if(v instanceof Map) {
				int key = txt.indexOf((String)arrKeys[i]);
				int  index1 = txt.indexOf("{", key);
				int  index2 = txt.indexOf("}", index1);
				v = newMap(txt.substring(index1,index2+1),false);
			}
			rs.put((String)arrKeys[i], v);
		}
		return (Map)rs;
	}
	
	/**
	 * @param map
	 * @param comparator
	 * @return
	 */
	public static  <K, V> Map<K,V> sort(Map<K,V> map,Comparator<K> comparator){
		Map<K, V> rs = newMap();
		K[] arrKeys = sortKeysArray(map,comparator);
		for (K k : arrKeys) {
			rs.put(k, map.get(k));
		}
		return rs;
	}
	
	/**
	 * @param map
	 * @param comparator
	 * @return Object[] 不能用K[] 来接收，不知道为啥
	 */
	@SuppressWarnings("unchecked")
	public  static <K, V> K[] sortKeysArray(Map<K,V> map,Comparator<K> comparator) {
		Set<K> keys = map.keySet();
		K[] arr = (K[])(new Object[keys.size()]);
		K[] arrKeys = keys.toArray(arr);
		Arrays.sort(arrKeys,comparator);
		return arr;
	}
	/**
	 * @param map
	 * @param comparator
	 * @return
	 */
	public  static <K, V> Set<K> sortKeysSet(Map<K,V> map,Comparator<K> comparator) {
		return new TreeSet<>(sortKeysList(map,comparator));
	}
	
	/**
	 * @param map
	 * @param comparator
	 * @return
	 */
	public  static <K, V> List<K> sortKeysList(Map<K,V> map,Comparator<K> comparator) {
		K[] keys = sortKeysArray(map,comparator);
		return Arrays.asList(keys);
	}
}
