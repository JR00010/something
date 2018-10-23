package test.com;

import java.util.Iterator;

import test.com.test.bean.Student;

public class Event {
    // 放置事件源的引用
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
	private  class command<E> implements Iterator<E>{
		private int index;
    	private command(){
    		
    	}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
    }
    public command<Student> getCommand(){
    	return new command<Student>();
    }
}