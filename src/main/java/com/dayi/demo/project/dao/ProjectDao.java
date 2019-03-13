package com.dayi.demo.project.dao;

import com.dayi.demo.project.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-26
 */
public interface ProjectDao {

    /**
     * 添加项目
     * @param project
     * @return
     */
    int addProject(Project project);

    /**
     * 查找所有项目
     * @return
     */
    List<Project> findAllProject();

    /**
     * 获取指定项目
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

    /**
     * 查找指定产品下的项目
     * @param productId
     * @return
     */
    List<Project> findByProductId(String productId);
}
