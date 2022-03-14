import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisText {
    private InputStream in;
    private  IUserDao userDao;
    @Before//在目标方法执行之前执行
    public void init() throws IOException {
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        userDao=new UserDaoImpl(factory);
    }
    @After
    public void destory() throws Exception{
        in.close();
    }
    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public  void testSave(){
        User user=new User();
        user.setUsername("change");
        user.setAddress("河南");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前："+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后："+user);
    }
    @Test
    public  void  testFindById(){
        int id=41;
        User user = userDao.findById(id);
        System.out.println("查询到的值为："+user);
    }
    @Test
    public void testDeleteUser(){
        int id=52;
        String uid = userDao.delete(id);
        if(uid!=null){
            System.out.println("删除成功！！！");
            System.out.println(uid);
        }
    }
    @Test
    public void testupdateUser(){
        User user = new User();
        user.setId(53);
        user.setUsername("change");
        user.setAddress("河南");
        user.setSex("女");
        user.setBirthday(new Date());
        Integer update = userDao.update(user);
        if (update!=null&&update!=0){
            System.out.println("修改成功！！！");
        }
    }
    @Test
    public void testfindByusername(){
        String username="%王%";
        List<User> users = userDao.findByusername(username);
        for(User user : users){
            System.out.println(user);
        }
    }
    @Test
    public  void testFindStripCount(){
        Integer findstripcount = userDao.findstripcount();
        System.out.println(findstripcount);
    }

}
