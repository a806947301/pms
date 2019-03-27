package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.dao.DepartmentDao;
import com.dayi.demo.user.model.Department;
import com.dayi.demo.user.service.DepartmentService;
import com.dayi.demo.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private UserService userService;

    @Override
    public void delete(String id) throws SystemException {
        //判断该部门下是否有用户
        int countUser = userService.countDepartmentId(id);
        if (0 != countUser) {
            throw new SystemException("部门人数不为0");
        }

        //删除部门
        int countDelete = departmentDao.delete(id);
        if (0 == countDelete) {
            throw new SystemException("删除失败");
        }
    }

    @Override
    public void update(Department department) throws SystemException {
        int countUpdate = departmentDao.update(department);
        //如果更新行数为0
        if (0 == countUpdate) {
            throw new SystemException("更新失败");
        }
    }

    @Override
    public void add(Department department) throws SystemException {
        int countAdd = departmentDao.add(department);
        //如果添加行数为0
        if (0 == countAdd) {
            throw new SystemException("添加失败");
        }
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();

    }

    @Override
    public PageInfo<Department> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Department> list = departmentDao.findAll();
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
