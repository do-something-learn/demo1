package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    @Override
    public List<User> findAll() {
        //根据factory获取SqlSession对象
        SqlSession session=factory.openSession();
        //调用SqlSession中的方法，实现查询列表
        List<User> users=session.selectList("com.itheima.dao.IUserDao.findAll");
        //释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        SqlSession session=factory.openSession();
        session.insert("com.itheima.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
    }

    @Override
    public User findById(Integer id) {
        SqlSession session=factory.openSession();
        User user=session.selectOne("com.itheima.dao.IUserDao.findById",id);
        session.commit();
        session.close();
        return user;
    }

    @Override
    public String delete(Integer id) {
        SqlSession session=factory.openSession();
        String delete = String.valueOf(session.delete("com.itheima.dao.IUserDao.deleteUser", id));
        session.commit();
        session.close();
        return delete;
    }

    @Override
    public Integer update(User user) {
        SqlSession session=factory.openSession();
        int justone = session.update("com.itheima.dao.IUserDao.updateUser",user);
        session.commit();//更新数据库
        session.close();
        return justone;
    }

    @Override
    public List<User> findByusername(String username) {
        SqlSession session=factory.openSession();
        List<User> objects = session.selectList("com.itheima.dao.IUserDao.findByName", username);
        session.close();
        return objects;
    }

    @Override
    public Integer findstripcount() {
        SqlSession session=factory.openSession();
        int o = session.selectOne("com.itheima.dao.IUserDao.findTotal");
        session.close();
        return o;
    }


}
