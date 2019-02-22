package com.dayi.demo.common.department.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.dayi.demo.common.department.dao.DepartmentDao;
import com.dayi.demo.common.department.model.Department;
import com.dayi.demo.common.department.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wut
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Override
    public int addDepartment(Department department) {
        return  departmentDao.addDepartment(department);
    }

    @Override
    public PageInfo<Department> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Department> list = departmentDao.findByPage();
        PageInfo<Department> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    public JSONObject pageToJson(PageInfo<Department> pageInfo) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageInfo",pageInfo);
        return jsonObject;
    }

}
