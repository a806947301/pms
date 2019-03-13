package com.dayi.demo.project.service;

import com.alibaba.fastjson.JSONArray;
import com.dayi.demo.project.model.Project;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author wut
 */
public interface ProjectService {
    /**
     * 添加项目
     *
     * @param project
     * @return
     */
    String addProject(Project project);

    /**
     * 分页查找项目
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Project> findByPage(int currentPage, int pageSize);

    /**
     * 根据产品id分页查项目
     *
     * @param productId
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Project> findByProductIdPage(String productId, int currentPage, int pageSize);

    /**
     * 查找所有产品
     *
     * @return
     */
    List<Project> findAll();

    /**
     * 通过项目id获取项目
     *
     * @param id
     * @return
     */
    Project getProject(String id);

    /**
     * 更新项目
     *
     * @param project
     * @return
     */
    int updateProject(Project project);


}
