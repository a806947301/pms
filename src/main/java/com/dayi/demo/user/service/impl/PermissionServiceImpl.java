package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.dao.PermissionDao;
import com.dayi.demo.user.model.Permission;
import com.dayi.demo.user.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 权限模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    @Override
    public void add(Permission permission) throws SystemException {
        int countAdd = permissionDao.add(permission);
        if (0 == countAdd) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public PageInfo<Permission> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Permission> list = permissionDao.findPermission();
        PageInfo<Permission> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.findPermission();
    }

    @Override
    public List<Permission> findPermissionMenu() {
        return permissionDao.findByIsMenu(true);
    }

    @Override
    public void update(Permission permission) throws SystemException {
        int countUpdate = permissionDao.update(permission);
        if (0 == countUpdate) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public JSONArray doPermissionTree(String roleId) {
        // 封装树结构权限，保存所有节点
        LinkedHashMap<String, JSONObject> assistMap = new LinkedHashMap<String, JSONObject>();
        List<Permission> list = findAll();
        for (Permission p : list) {
            JSONObject node = new JSONObject();
            // 如果是菜单，需要加一个数组
            if (p.getMenu()) {
                node.put("nodes", new JSONArray());
            }
            node.put("id", p.getId());
            node.put("text", p.getPermissionName());
            node.put("parent", p.getParentId());

            // 如果有父节点，则加入到父节点
            boolean hasParent = !("".equals(p.getParentId()));
            if (hasParent) {
                JSONArray parentNodes = (JSONArray) (assistMap.get(p.getParentId()).get("nodes"));
                parentNodes.add(node);
            }
            assistMap.put(p.getId(), node);
        }

        // 给角色已有的权限加上checked
        List<Permission> rolePermission = findByRoleId(roleId);
        for (Permission p : rolePermission) {
            JSONObject checked = new JSONObject();
            checked.put("checked", true);
            assistMap.get(p.getId()).put("state", checked);
        }

        // 循环遍历，把没有父节点的加到tree上
        JSONArray tree = new JSONArray();
        Iterator<String> iter = assistMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            JSONObject val = assistMap.get(key);
            if ("".equals(val.get("parent"))) {
                tree.add(val);
            }
        }
        return tree;
    }

    @Override
    public List<Permission> findByRoleId(String roleId) {
        return permissionDao.findByRoleId(roleId);
    }

    @Override
    public int doAuthorization(String roleId, String[] permissionsId) {
        //删除已有权限
        permissionDao.deleteRolePermission(roleId, null);

        //授权
        int countAdd = 0;
        BaseEntity entity;
        PermissionService proxyService = (PermissionService) AopContext.currentProxy();
        for (String permissionId : permissionsId) {
            entity = new BaseEntity();
            countAdd += proxyService.addRolePermission(entity, roleId, permissionId);
        }
        return countAdd;
    }

    @Override
    public int addRolePermission(BaseEntity entity, String roleId, String permissionId) {
        return permissionDao.addRolePermission(entity.getId(), entity.getAddTime(), entity.getUpdateTime(),
                roleId, permissionId);
    }

    @Override
    public void delete(String id) throws SystemException {
        int countDelete = permissionDao.delete(id);
        permissionDao.deleteRolePermission(null, id);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public void deleteRolePermission(String roleId, String permissionId) throws SystemException {
        int countDelete = permissionDao.deleteRolePermission(roleId, permissionId);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }
}
