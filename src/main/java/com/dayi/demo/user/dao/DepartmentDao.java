package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.Department;

import java.util.List;

/**
 * @Author wut
 */
public interface DepartmentDao {

    /**
     * 添加部门
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 更新部门
     * @param department
     * @return
     */
    int updateDepartment(Department department);

    /**
     * 删除部门
     * @param id
     * @return
     */
    int deleteDepartment(String id);

    /**
     * 获取指定部门
     * @param id
     * @return
     */
    Department getDepartment(String id);

    /**
     * 查找所有部门
     * @return
     */
    List<Department> findAll();
}
