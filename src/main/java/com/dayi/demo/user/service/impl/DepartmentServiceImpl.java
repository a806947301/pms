package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.util.IdUtil;
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
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 删除部门
     * @param id    部门id
     * @return
     */
    @Override
    public int deleteDepartment(String id) {
        return departmentDao.deleteDepartment(id);
    }

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    @Override
    public int updateDepartment(Department department) {
        department.setUpdateTime(new Date());
        return departmentDao.updateDepartment(department);
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    @Override
    public int addDepartment(Department department) {
        department.setAddTime(new Date());
        department.setUpdateTime(new Date());
        department.setId(IdUtil.getPrimaryKey());
        return  departmentDao.addDepartment(department);
    }

    /**
     *  查看所有部门
     * @return
     */
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();

    }

    /**
     * 分页查看部门
     * @param currentPage   页号
     * @param pageSize  页面大小
     * @return
     */
    @Override
    public PageInfo<Department> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Department> list = departmentDao.findAll();
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public JSONObject listToJson(List<Department> list)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",list);
        return jsonObject;
    }
}
