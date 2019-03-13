package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.dao.RoleDao;
import com.dayi.demo.user.model.Role;
import com.dayi.demo.user.service.PremissionService;
import com.dayi.demo.user.service.RoleService;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-3-10
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private PremissionService premissionService;

    @Override
    public int addRole(Role role) {
        role.setId(IdUtils.getPrimaryKey());
        role.setAddTime(new Date());
        role.setUpdateTime(new Date());
        return roleDao.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        role.setUpdateTime(new Date());
        return roleDao.updateRole(role);
    }

    @Override
    public PageInfo<Role> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Role> list = roleDao.findRole();
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findRole();
    }

    @Override
    public List<Role> findRoleByUserId(String userId) {
        return roleDao.findRoleByUserId(userId);
    }

    @Override
    public int doAscribedRole(String userId, String roleId) {
        return roleDao.addUserRole(IdUtils.getPrimaryKey(),new Date(),new Date(),userId,roleId);
    }

    @Override
    public int doCancelRole(String userId, String roleId) {
        return roleDao.deleteUserRole(userId,roleId);
    }

    @Override
    public int deleteRole(String id) {
        int countDelete = roleDao.deleteRole(id);
        countDelete += premissionService.deleteRolePremission(id,null);
        countDelete += roleDao.deleteUserRole(null,id);
        return countDelete;
    }
}
