package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * 用户持久层
 */
public interface IUserDao {
    /**
     * 查询操作
     */
    List<User> findAll();
    /**
     * 保存用户
     */
    void  saveUser(User user);
    /**
     * 根据id进行查询
     */
    User  findById(Integer id);
    /**
     * 根据id进行删除
     */
    String delete(Integer id);
    /**
     * 更新数据
     */
    Integer update(User user);
    /**
     * 根据名字进行查询
     *
     */
    List<User> findByusername(String username);
    /**
     *
     */
    Integer findstripcount();
    //sucessful
}
