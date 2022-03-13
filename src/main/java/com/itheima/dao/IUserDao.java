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
    User findUsername();
}
