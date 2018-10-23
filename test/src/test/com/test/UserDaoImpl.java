package test.com.test;
public class UserDaoImpl extends GetGenericUtil<User>{

    public User getUser() throws Exception{
        Object obj = this.getMyClass().newInstance();//得到泛型类，然后创建一个新实例。
        if(obj instanceof User){
            return (User)obj;           
        }else{
            return null;
        }

    }
    public User getUser(String id) throws Exception{
        Object obj = this.getMyClass().newInstance();//得到泛型类，然后创建一个新实例。
        if(obj instanceof User){
            return (User)obj;           
        }else{
            return null;
        }

    }

    public static void main(String[] args) throws Exception {

            User u = new UserDaoImpl().getUser();

            System.out.println(u+"----");

    }

}