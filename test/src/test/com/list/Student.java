package test.com.list;

public class Student implements Comparable<Student>{
    //学生姓名
    private String name;
    //学生年龄
    private int age;

    //无参构造
    public Student() {
        // TODO Auto-generated constructor stub
    }

    // 带参构造
    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //getXxx() setXxx()方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        //按照年龄排序，主要条件
        int num = this.age- s.age;

        //如果年龄相同，比较姓名，如果姓名相同的话，才是同一个对象
        int num1 = num == 0 ? this.name.compareTo(s.name) : num;
        return num1;
    }
}
