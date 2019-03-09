package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.Department;

import java.util.List;

/**
 * @Author wut
 */
public interface DepartmentDao {
    int addDepartment(Department department);
    int updateDepartment(Department department);
    int deleteDepartment(String id);
    Department getDepartment(String id);
    List<Department> findAll();
}
