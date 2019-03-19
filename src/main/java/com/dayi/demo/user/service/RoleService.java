package com.dayi.demo.user.service;

import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-3-10
 */
public interface RoleService {

    /**
     * 添加角色
     * @param role
     * @throws SystemException
     */
    void add(Role role) throws SystemException;

    /**
     * 更新角色
     *
     * @param role
     * @return
     * @throws SystemException
     */
    void update(Role role) throws SystemException ;

    /**
     * 分页查询角色
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Role> findByPage(int currentPage, int pageSize);

    /**
     * 查询所有的角色
     *
     * @return
     */
    List<Role> findAll();

    /**
     * 查询指定用户拥有的角色
     *
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(String userId);

    /**
     * 给用户赋予角色
     *
     * @param userId
     * @param roleId
     * @return
     * @throws SystemException
     */
    void doAscribedRole(String userId, String roleId) throws SystemException;

    /**
     * 取消用户角色
     *
     * @param userId
     * @param roleId
     * @return
     * @throws SystemException
     */
    void doCancelRole(String userId, String roleId) throws SystemException ;

    /**
     * 删除角色
     *
     * @param id
     * @return
     * @throws SystemException
     */
    int delete(String id) throws SystemException ;

    /**
     * 获取指定角色名的角色
     * @param roleName
     * @return
     */
    Role getRoleByRoleName(String roleName);

    /**
     * 获取指定角色
     * @param id
     * @return
     */
    Role get(String id);
}
