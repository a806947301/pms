package com.dayi.demo.user.service;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author wut
 */
public interface RoleService {

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 更新角色
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 分页查询角色
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Role> findByPage(int currentPage,int pageSize);

    /**
     * 查询所有的角色
     * @return
     */
    List<Role> findAll();

    /**
     * 查询指定用户拥有的角色
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(String userId);

    /**
     * 给用户赋予角色
     * @param userId
     * @param roleId
     * @return
     */
    int doAscribedRole(String userId,String roleId);

    /**
     * 取消用户角色
     * @param userId
     * @param roleId
     * @return
     */
    int doCancelRole(String userId,String roleId);

    /**
     * 删除角色
     * @param id
     * @return
     */
    int deleteRole(String id);
}
