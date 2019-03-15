package com.dayi.demo.user.service;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.Department;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 部门模块接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-22
 */
public interface DepartmentService {
    /**
     * 添加部门
     *
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 分页查询部门
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Department> findByPage(int currentPage, int pageSize);

    /**
     * 更新部门
     *
     * @param department
     * @return
     */
    int updateDepartment(Department department);

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    int deleteDepartment(String id);

    /**
     * 查询所有部门
     *
     * @return
     */
    List<Department> findAll();
}
