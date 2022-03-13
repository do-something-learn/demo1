import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisText {
    public static void main(String[] args) throws Exception {
        //读取配置
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //使用工厂生产SqlSession对象
        SqlSession session=factory.openSession();
        //使用SalSession创建Dao接口的代理对象
        IUserDao userDao=session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }
}
