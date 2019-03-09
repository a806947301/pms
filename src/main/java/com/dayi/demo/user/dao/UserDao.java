package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.User;

import java.util.List;

/**
 * @Author wut
 */
public interface UserDao {
    List<User> findAll();
    List<User> findAllIncludeStopped();
    int addUser(User user);
    int updateUser(User user);
    List<User> findUserByProductId(String productId);
    User getUser(String id);
    User getUserByEmail(String email);
}
