package test.com.vpatten;

public class Client {
	public static void main(String[] args) throws Exception {
//		SubjectOne subject = new SubjectOne();
//		ObserverOne t = new ObserverOne(subject);
//		subject.add(t);
//		for (int i = 0; i < 3; i++) {
//			subject.add(new ObserverOne(String.valueOf(i),subject));
//		}
//		
//		subject.setSubjectContent("date is 9/22");
//		t.remove();
//		subject.noteAll();
		try{
			int i =8/0;
		}catch(Exception e){
			e.printStackTrace();
			throw  new Exception(e.getMessage());
		}
	}
}
