package com.dayi.demo.user.service;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 *
 * 用户模块业务接口
 *
 * @Author wut
 */
public interface UserService {
    /**
     * 分页查询用户数据
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<User> findByPage(int currentPage, int pageSize);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询所有用户数据
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据产品id 查找所有参与产品的用户
     * @param productId    产品id
     * @return
     */
    List<User> findUserByProductId(String productId);

    /**
     * 查找指定用户
     * @param id 用户id
     * @return
     */
    User getUser(String id);

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    boolean doLogin(String email,String password,String ip) ;

    /**
     * 根据邮箱获取用户
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 修改用户停用状态
     * @param stopped
     * @return
     */
    int updateUserStopped(String id,boolean stopped);

    /**
     * 退出登陆
     * @return
     */
    boolean doLogout();
}
