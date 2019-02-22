package com.dayi.demo.common.department.service;

import com.dayi.demo.common.department.model.Department;
import com.github.pagehelper.PageInfo;

/**
 * @Author wut
 */
public interface DepartmentService {
    int addDepartment(Department department);
    PageInfo<Department> findByPage(int currentPage,int pageSize);
}
