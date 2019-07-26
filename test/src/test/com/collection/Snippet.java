package test.com.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Snippet {
	public static void main(String[] args) {
//		IConvert<String, Matchs> convert = Matchs::new;
//		List<Matchs> matchsList = new ArrayList<Matchs>();
//		new Matchs("li",9);
//		matchsList.add(new Matchs("li",7));
//		matchsList.add(new Matchs("ni",10));
//		matchsList.add(new Matchs("li",9));
//		matchsList.add(new Matchs("li",6));
//		matchsList.add(new Matchs("ni",5));
//		IConvert<Comparator<Matchs>, TreeMap> d= TreeMap::new;
//		TreeMap<String, List<Matchs>> matchsListMap = matchsList.stream()
//				.collect(Collectors.groupingBy(Matchs::getName,TreeMap::new,Collectors.toList()));
//		System.err.println(matchsListMap.toString());
//		
//		Set<Matchs> s = new HashSet<>();
//		TreeSet<Matchs> s1 = new TreeSet<>();
//		s.add(new Matchs("li",7));
//		s1.add(new Matchs("ni",10));
//		s1.add(new Matchs("s",99));
//		s.add(new Matchs("li",9));
//		s.add(new Matchs("li",6));
//		s.add(new Matchs("ni",5));
//		s.add(new Matchs("s",48));
//		Integer i = null;
//		set(i);
//		System.err.println(i);
		Map<User, String> map = new HashMap<User, String>();
		User u = new User("liu", 25);
		User u1 = new User("liu", 25);
		map.put(u, "30");
		System.err.println(map.get(u1));
		
	}
	
	public static void set(int i){
		System.err.println(i);
	}

}

@FunctionalInterface
interface IConvert<F, T> {
    T convert(F form);
}
class Matchs implements Comparable<Matchs>{
	private  String name;
	private  Integer age;
	
	public Matchs() {
		super();
	}
	public Matchs(String s) {
		super();
	}
	public Matchs(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Matchs [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Matchs o) {
//		if (this.name .equals(o.name)) {
//			return 0;
//		}
		if (this.age>o.age&&!this.name .equals(o.name)) {
			return 1;
		}
		if (this.age<o.age&&!this.name .equals(o.name)) {
			return -1;
		}
			return 0;
//			
//		       //按照年龄排序，主要条件
//	        int num = this.age- o.age;
//
//	        //如果年龄相同，比较姓名，如果姓名相同的话，才是同一个对象
//	        int num1 = num == 0 ? this.name.compareTo(o.name) : num;
//	        return num1;
	}
	@Override
	public int hashCode() {
		int result = 1;
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matchs other = (Matchs) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}


class Something {
	 
    // constructor methods
    Something() {}
 
    Something(String something) {
	System.out.println(something);
    }
 
    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
    
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }
    
    void endWith() {}

}