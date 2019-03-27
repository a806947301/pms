package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
public interface UserDao {

    /**
     * 查找用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 查找所有用户，包括已停用的
     *
     * @return
     */
    List<User> findAllIncludeStopped();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 查找指定产品下的用户
     *
     * @param productId
     * @return
     */
    List<User> findUserByProductId(String productId);

    /**
     * 查找指定产品指定角色的用户
     *
     * @param productId
     * @param roleId
     * @return
     */
    List<User> findUserByproductIdRole(@Param("productId") String productId, @Param("roleId") String roleId);

    /**
     * 根据用户角色表查询用户
     *
     * @param userId
     * @param roleId
     * @return
     */
    List<User> findUserByUserRole(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 获取指定用户
     *
     * @param id
     * @return
     */
    User get(String id);

    /**
     * 根据邮箱获取指定用户
     *
     * @param email 邮箱
     * @return
     */
    User getByEmail(String email);

    /**
     * 获取指定的产品参与者
     *
     * @param productId
     * @param userId
     * @return
     */
    User getProductUser(@Param("productId") String productId, @Param("userId") String userId);

    /**
     * 查找部门人数
     *
     * @param departmentId
     * @return
     */
    int countDepartmentId(String departmentId);

    /**
     * 用户是否参与产品
     *
     * @param userId
     * @param productId
     * @return
     */
    boolean isInProduct(@Param("userId") String userId, @Param("productId") String productId);
}
