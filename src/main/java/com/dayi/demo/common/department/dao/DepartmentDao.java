package com.dayi.demo.common.department.dao;

import com.dayi.demo.common.department.model.Department;

import java.util.List;

/**
 * @Author wut
 */
public interface DepartmentDao {

    int addDepartment(Department department);

    List<Department> findByPage();
}
