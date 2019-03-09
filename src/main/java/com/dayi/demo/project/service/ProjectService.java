package com.dayi.demo.project.service;

import com.dayi.demo.project.model.Project;
import com.github.pagehelper.PageInfo;

/**
 * @Author wut
 */
public interface ProjectService {
    /**
     * 添加项目
     * @param project
     * @return
     */
    String addProject(Project project);

    /**
     * 分页查找项目
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Project> findByPage(int currentPage,int pageSize);

    /**
     * 通过项目id获取项目
     * @param id
     * @return
     */
    Project getProject(String id);

    /**
     * 更新项目
     * @param project
     * @return
     */
    int updateProject(Project project);
}
