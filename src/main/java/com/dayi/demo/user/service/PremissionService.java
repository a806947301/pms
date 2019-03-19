package com.dayi.demo.user.service;

import com.alibaba.fastjson.JSONArray;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.Premission;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-06
 */
public interface PremissionService {

    /**
     * 添加权限
     *
     * @param premission
     * @throws SystemException
     */
    void add(Premission premission) throws SystemException;

    /**
     * 分页查找权限
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Premission> findByPage(int currentPage, int pageSize);

    /**
     * 查找所有权限
     *
     * @return
     */
    List<Premission> findAll();

    /**
     * 查找所有是菜单的权限
     *
     * @return
     */
    List<Premission> findPremissionMenu();

    /**
     * 修改权限
     *
     * @param premission
     * @throws SystemException
     */
    void update(Premission premission) throws SystemException;

    /**
     * 封装成权限树数据
     *
     * @param roleId
     * @return
     */
    JSONArray doPremissionTree(String roleId);

    /**
     * 查找角色拥有的权限
     *
     * @param roleId
     * @return
     */
    List<Premission> findByRoleId(String roleId);

    /**
     * 给角色授权
     *
     * @param roleId
     * @param premissionsId
     * @return
     */
    int doAuthorization(String roleId, String[] premissionsId);

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
     * @param premissionId
     * @throws SystemException
     */
    void deleteRolePremission(String roleId, String premissionId) throws SystemException;
}
