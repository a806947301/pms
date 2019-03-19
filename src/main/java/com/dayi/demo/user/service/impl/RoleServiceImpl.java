package com.dayi.demo.user.service.impl;

import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.dao.RoleDao;
import com.dayi.demo.user.model.Premission;
import com.dayi.demo.user.model.Role;
import com.dayi.demo.user.service.PremissionService;
import com.dayi.demo.user.service.RoleService;
import com.dayi.demo.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-3-10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private PremissionService premissionService;

    @Override
    public void add(Role role) throws SystemException {
        int countAdd = roleDao.add(role);
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
        role.setUpdateTime(new Date());
        int countUpdate = roleDao.update(role);
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
        int countAdd = roleDao.addUserRole(IdUtil.getPrimaryKey(), new Date(), new Date(), userId, roleId);
        if (0 == countAdd) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public void doCancelRole(String userId, String roleId) throws SystemException{
        int countDelete = roleDao.deleteUserRole(userId, roleId);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public int delete(String id) throws SystemException {
        // 判断是否改角色是否还有权限
        List<Premission> premissions = premissionService.findByRoleId(id);
        if (0 != premissions.size()) {
            return 0;
        }
        // 判断是否有用户有此角色
        List<Role> roles = roleDao.findByUserRole(null, id);
        if (0 != roles.size()) {
            return 0;
        }
        int countDelete = roleDao.delete(id);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
        return countDelete;
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
