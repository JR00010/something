package test.com;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class User {
	public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
	public static void main(String[] args) {
		User u1 =new User();
		u1.setId("1");
		User u2 =new User();
		u2.setId("1");
		Set<User> s = new HashSet<>();
		s.add(u2);
		s.add(u1);
		System.err.println(s.toString());
	}
	String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
