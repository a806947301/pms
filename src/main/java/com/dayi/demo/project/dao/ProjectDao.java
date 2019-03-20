package com.dayi.demo.project.dao;

import com.dayi.demo.project.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-26
 */
public interface ProjectDao {

    /**
     * 添加项目
     *
     * @param project
     * @return
     */
    int add(Project project);

    /**
     * 查找所有项目
     *
     * @return
     */
    List<Project> findAll();

    /**
     * 获取指定项目
     *
     * @param id
     * @return
     */
    Project get(String id);

    /**
     * 更新项目
     *
     * @param project
     * @return
     */
    int update(Project project);

    /**
     * 查找指定产品下的项目
     *
     * @param productId
     * @return
     */
    List<Project> findByProductId(String productId);

    /**
     * 更新项目完成状态
     *
     * @param id
     * @param finished
     * @return
     */
    int updateIsFinished(@Param("id") String id, @Param("finished") boolean finished);

    /**
     * 删除项目
     *
     * @param id
     * @return
     */
    int delete(String id);
}
