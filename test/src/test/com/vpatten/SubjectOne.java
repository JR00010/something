package test.com.vpatten;

import java.util.HashSet;
import java.util.Set;

public class SubjectOne implements Subject {
	private Set<Observer> o = new HashSet<>() ;
	private String subjectContent = "";
	public SubjectOne() {
	}
	@Override
	public Subject add(Observer o){
		this.o.add(o);
		return this;
	}
	@Override
	public Subject remove(Observer o ){
		this.o.remove(o);
		return this;
	}
	public void noteAll(){
		for (Observer observer : o) {
			observer.receive(this);
		}
	}
	public void note(Observer o){
		o.receive(this);
	}
	public String getSubjectContent() {
		return subjectContent;
	}
	public void setSubjectContent(String subjectContent) {
		this.subjectContent = subjectContent;
	}
}
