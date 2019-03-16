package com.dayi.demo.need.dao;

import com.dayi.demo.need.model.Need;

import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @Date 2019-03-04
 */
public interface NeedDao {

    /**
     * 添加需求
     * @param need
     * @return
     */
    int add(Need need);

    /**
     * 查找指定项目下的Bug需求
     * @param projectId
     * @return
     */
    List<Need> findByprojectId(String projectId);

    /**
     * 获取指定的Bug需求
     * @param id
     * @return
     */
    Need get(String id);
}
