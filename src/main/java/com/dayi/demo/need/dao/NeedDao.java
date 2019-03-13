package com.dayi.demo.need.dao;

import com.dayi.demo.need.model.Need;

import java.util.List;

/**
 * @Author wut
 * @Date 2019-03-04
 */
public interface NeedDao {

    /**
     * 添加需求
     * @param need
     * @return
     */
    int addNeed(Need need);

    /**
     * 查找指定项目下的Bug需求
     * @param projectId
     * @return
     */
    List<Need> findNeedByprojectId(String projectId);

    /**
     * 获取指定的Bug需求
     * @param id
     * @return
     */
    Need getNeed(String id);
}
