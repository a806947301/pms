package com.dayi.demo.user.service;

import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * 用户模块Service层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
public interface UserService {
    /**
     * 分页查询用户数据
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<User> findByPage(int currentPage, int pageSize);

    /**
     * 添加用户
     *
     * @param user
     * @return
     * @throws SystemException
     */
    void add(User user) throws SystemException;

    /**
     * 更新用户数据
     *
     * @param user
     * @return
     * @throws SystemException
     */
    void update(User user) throws SystemException;

    /**
     * 查询所有用户数据
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据产品id 查找所有参与产品的用户
     *
     * @param productId 产品id
     * @return
     */
    List<User> findByProductId(String productId);

    /**
     * 根据用户角色表查询用户
     *
     * @param userId
     * @param roleId
     * @return
     */
    List<User> findByUserRole(String userId, String roleId);

    /**
     * 查找指定用户
     *
     * @param id 用户id
     * @return
     */
    User get(String id);

    /**
     * 登录
     *
     * @param email
     * @param password
     * @param ip
     * @return
     */
    boolean doLogin(String email, String password, String ip);

    /**
     * 根据邮箱获取用户
     *
     * @param email
     * @return
     */
    User getByEmail(String email);

    /**
     * 退出登陆
     *
     * @return
     */
    void doLogout();

    /**
     * 查询产品下指定角色的用户
     *
     * @param productId
     * @param roleId
     * @return
     */
    List<User> findByproductIdRole(String productId, String roleId);

    /**
     * 随机生成注册验证码发送到邮箱
     *
     * @param email
     * @return
     * @throws SystemException
     */
    String doRandomVarificationCodeToEmail(String email) throws SystemException;

    /**
     * 验证邮箱是否已存在
     *
     * @param email
     * @return
     */
    boolean doExistEmail(String email);

    /**
     * 部门的人数
     *
     * @param departmentId
     * @return
     */
    int countDepartmentId(String departmentId);

    /**
     * 判断用户是否参与产品
     *
     * @param userId
     * @param productId
     * @return
     */
    boolean isInProduct(String userId, String productId);
}
