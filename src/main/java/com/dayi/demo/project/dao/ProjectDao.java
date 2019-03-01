package com.dayi.demo.project.dao;

import com.dayi.demo.project.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wut
 */
public interface ProjectDao {
    int addProject(Project project);
    List<Project> findAllProduct();
    Project getProject(String id);
    int updateProject(Project project);
}
