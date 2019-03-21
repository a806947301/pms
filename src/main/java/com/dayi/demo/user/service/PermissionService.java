package com.dayi.demo.user.service;

import com.alibaba.fastjson.JSONArray;
import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.Permission;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 权限模块Service层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-06
 */
public interface PermissionService {

    /**
     * 添加权限
     *
     * @param permission
     * @throws SystemException
     */
    void add(Permission permission) throws SystemException;

    /**
     * 分页查找权限
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Permission> findByPage(int currentPage, int pageSize);

    /**
     * 查找所有权限
     *
     * @return
     */
    List<Permission> findAll();

    /**
     * 查找所有是菜单的权限
     *
     * @return
     */
    List<Permission> findPermissionMenu();

    /**
     * 修改权限
     *
     * @param permission
     * @throws SystemException
     */
    void update(Permission permission) throws SystemException;

    /**
     * 封装成权限树数据
     *
     * @param roleId
     * @return
     */
    JSONArray doPermissionTree(String roleId);

    /**
     * 查找角色拥有的权限
     *
     * @param roleId
     * @return
     */
    List<Permission> findByRoleId(String roleId);

    /**
     * 给角色授权
     *
     * @param roleId
     * @param permissionsId
     * @return
     */
    int doAuthorization(String roleId, String[] permissionsId);

    /**
     * 给角色授权
     *
     * @param entity
     * @param roleId
     * @param permissionId
     * @return
     */
    public int addRolePermission(BaseEntity entity, String roleId, String permissionId);

    /**
     * 删除权限
     *
     * @param id
     * @throws SystemException
     */
    void delete(String id) throws SystemException;

    /**
     * 删除角色权限表（中间表）
     * @param roleId
     * @param permissionId
     * @throws SystemException
     */
    void deleteRolePermission(String roleId, String permissionId) throws SystemException;
}
