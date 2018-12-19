package test.com.BeanUtil;

public class WrapUser extends User{
	private String status ;

	public String getStatus() {
		if (this.getName().equals("li")) {
			return "A";
		}
		return status;
	}

	public void setStatus(String status) {
		
		this.status = "dsiu";
	}

	@Override
	public String toString() {
		return "WrapUser [status=" + status + ", getStatus()=" + getStatus() + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
