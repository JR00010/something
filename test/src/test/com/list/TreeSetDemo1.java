package test.com.list;

import java.util.TreeSet;


public class TreeSetDemo1 {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<Student> ts = new TreeSet<Student>();

        //创建元素
//        Student s1 = new Student("hello", 27);
//        Student s2 = new Student("world", 66);
//        Student s3 = new Student("hello", 27);
//        Student s4 = new Student("java", 63);
//        Student s5 = new Student("world", 65);
//        Student s6 = new Student("eclipse", 99);
        //添加元素
//        ts.add(s1);
//        ts.add(s2);
//        ts.add(s3);
//        ts.add(s4);
//        ts.add(s5);
//        ts.add(s6);
//		ts.add(new Matchs("li",7));
        ts.add(new Student("zhang",10));
        ts.add(new Student("wang",99));
//		s.add(new Matchs("li",9));
//		s.add(new Matchs("li",6));
//		s.add(new Matchs("ni",5));
//		s.add(new Matchs("s",48));
        ts.add(new Student("wang",5));
        int vb  = 1;
         vb &=1;
         System.err.println(vb);
        //遍历
//        for(Student s : ts){
//            System.out.println(s.getName() + "-------" + s.getAge());
//        }
        ts.forEach(System.out::println);

    }
}
