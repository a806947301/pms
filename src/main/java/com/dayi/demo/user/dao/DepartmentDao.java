package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.Department;

import java.util.List;

/**
 * 部门dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-22
 */
public interface DepartmentDao {

    /**
     * 添加部门
     *
     * @param department
     * @return
     */
    int add(Department department);

    /**
     * 更新部门
     *
     * @param department
     * @return
     */
    int update(Department department);

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 获取指定部门
     *
     * @param id
     * @return
     */
    Department get(String id);

    /**
     * 查找所有部门
     *
     * @return
     */
    List<Department> findAll();
}
