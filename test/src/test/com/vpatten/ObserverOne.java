package test.com.vpatten;

public class ObserverOne implements Observer {
	private final Subject s ;
	private String name;
	public ObserverOne(String name,SubjectOne subject){
		this.name = name;
		this.s = subject;
	}
	public ObserverOne(SubjectOne subject) {
		this.s = subject;
	}
	@Override
	public void receive(SubjectOne subjectOne) {
		System.err.println(subjectOne.getSubjectContent());
	}

	@Override
	public void remove() {
		s.remove(this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
