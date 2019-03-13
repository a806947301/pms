package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.User;

import java.util.List;

/**
 * @Author wut
 */
public interface UserDao {

    /**
     * 查找用户
     * @return
     */
    List<User> findAll();

    /**
     * 查找所有用户，包括已停用的
     * @return
     */
    List<User> findAllIncludeStopped();

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查找指定产品下的用户
     * @param productId
     * @return
     */
    List<User> findUserByProductId(String productId);

    /**
     * 获取指定用户
     * @param id
     * @return
     */
    User getUser(String id);

    /**
     * 根据邮箱获取指定用户
     * @param email 邮箱
     * @return
     */
    User getUserByEmail(String email);
}
