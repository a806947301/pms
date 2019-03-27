package com.dayi.demo.user.service.impl;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.dao.RoleDao;
import com.dayi.demo.user.model.Permission;
import com.dayi.demo.user.model.Role;
import com.dayi.demo.user.service.PermissionService;
import com.dayi.demo.user.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-3-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private PermissionService permissionService;

    @Override
    public void add(Role role) throws SystemException {
        int countAdd = roleDao.add(role);
        //如果数据库影响行数为0
        if (0 == countAdd) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public void update(Role role) throws SystemException {
        //判断是否存在
        Role oldRole = get(role.getId());
        if (null == oldRole) {
            throw new SystemException("角色不存在");
        }

        //更新角色
        int countUpdate = roleDao.update(role);
        //如果数据库更新行数为0
        if (0 == countUpdate) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public PageInfo<Role> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Role> list = roleDao.find();
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Role> findAll() {
        return roleDao.find();
    }

    @Override
    public List<Role> findRoleByUserId(String userId) {
        return roleDao.findByUserRole(userId, null);
    }

    @Override
    public void doAscribedRole(String userId, String roleId) throws SystemException{
        BaseEntity entity = new BaseEntity();
        //获取代理对象
        RoleService serviceProxy = (RoleService) AopContext.currentProxy();
        //授权
        int countAdd = serviceProxy.addUserRole(entity, userId, roleId);
        //如果数据库添加行数为0
        if (0 == countAdd) {
            throw new SystemException("操作失败");
        }
    }

    /**
     * 给用户添加角色
     *
     * @param entity
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public int addUserRole(BaseEntity entity, String userId, String roleId) {
        return roleDao.addUserRole(entity.getId(), entity.getAddTime(), entity.getUpdateTime(),
                userId, roleId);
    }

    @Override
    public void doCancelRole(String userId, String roleId) throws SystemException{
        int countDelete = roleDao.deleteUserRole(userId, roleId);
        //如果数据库删除行数为0
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public void delete(String id) throws SystemException {
        // 判断是否改角色是否还有权限
        List<Permission> permissions = permissionService.findByRoleId(id);
        if (0 != permissions.size()) {
            throw new SystemException("角色下还有权限");
        }
        // 判断是否有用户有此角色
        List<Role> roles = roleDao.findByUserRole(null, id);
        if (0 != roles.size()) {
            throw new SystemException("还有用户拥有此角色");
        }
        int countDelete = roleDao.delete(id);
        //如果数据库删除行数为0
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleDao.getByRoleName(roleName);
    }

    @Override
    public Role get(String id) {
        return roleDao.get(id);
    }
}
