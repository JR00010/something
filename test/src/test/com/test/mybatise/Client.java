package test.com.test.mybatise;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import test.com.test.GetGenericUtil;
import test.com.test.UserDaoImpl;
import test.com.test.bean.Student;
import test.com.test.impl.ReadListener;
/*
 * 
 *  ni
 */
public class Client {
	/**
	 * sting 内容的格式话对齐
	 * 默认是左对齐，%-3s是右对齐 三个空格
	 */
	@Test
	public void Client() {
		System.err.println(String.format("\nwww%114s", "------"));
		System.out.print(String.format("%10s232", "a"));
	}
	@Test
	public void stat() throws IOException{
		String resource = "org/mybatis/example/mybatis-config.xml";
		this.getClass().getResourceAsStream(resource);
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  Object blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
		} finally {
		  session.close();
		}
	}
	@Test
	public void t2(){
		String s = null;
		assert s!=null?true:false;
		assert false;
		System.err.println("end");
	}
	@Test
	public void t(){
		ReadListener readListener = new ReadListener();
		Student student = new Student();
		student.setReadListener(readListener);
		// 当执行这个方法时，会自动调用ReadListener.isReading()方法
		student.read();
	}
	@Test
	public void main()    {
		Boolean b= GetGenericUtil.class.isAssignableFrom(UserDaoImpl.class);
		System.err.println(b);
	}
	public static void main(String[] args) {
		HashMap<String, Object> m = new HashMap<>();
		m.put("1", 1);
		m.get(null);
	}
}
