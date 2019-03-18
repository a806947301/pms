package com.dayi.demo.user.service;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.exception.SystemException;
import com.dayi.demo.user.model.Department;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 部门模块接口
 *
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-2-22
 */
public interface DepartmentService {
    /**
     * 添加部门
     *
     * @param department
     * @throws SystemException
     */
    void add(Department department) throws SystemException;

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
     * @throws SystemException
     */
    void update(Department department) throws SystemException;

    /**
     * 删除部门
     *
     * @param id
     * @throws SystemException
     */
    void delete(String id) throws SystemException;

    /**
     * 查询所有部门
     *
     * @return
     */
    List<Department> findAll();
}
