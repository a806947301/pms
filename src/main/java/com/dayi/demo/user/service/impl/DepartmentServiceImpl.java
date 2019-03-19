package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.dao.DepartmentDao;
import com.dayi.demo.user.model.Department;
import com.dayi.demo.user.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 部门模块Service层实现类
 *
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-2-22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 删除部门
     *
     * @param id 部门id
     * @return
     */
    @Override
    public void delete(String id) throws SystemException {
        int countDelete = departmentDao.delete(id);
        if (0 == countDelete) {
            throw new SystemException("删除失败");
        }
    }

    /**
     * 更新部门信息
     *
     * @param department
     * @return
     */
    @Override
    public void update(Department department) throws SystemException {
        department.setUpdateTime(new Date());
        int countUpdate = departmentDao.update(department);
        if (0 == countUpdate) {
            throw new SystemException("更新失败");
        }
    }

    /**
     * 添加部门
     *
     * @param department
     * @return
     */
    @Override
    public void add(Department department) throws SystemException {
        int countAdd =  departmentDao.add(department);
        if(0 == countAdd) {
            throw new SystemException("添加失败");
        }
    }

    /**
     * 查看所有部门
     *
     * @return
     */
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();

    }

    /**
     * 分页查看部门
     *
     * @param currentPage 页号
     * @param pageSize    页面大小
     * @return
     */
    @Override
    public PageInfo<Department> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Department> list = departmentDao.findAll();
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public JSONObject listToJson(List<Department> list) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", list);
        return jsonObject;
    }
}
