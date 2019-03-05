package com.dayi.demo.need.dao;

import com.dayi.demo.need.model.Need;

import java.util.List;

/**
 * @Author wut
 * @Date 2019-03-04
 */
public interface NeedDao {
    int addNeed(Need need);
    List<Need> findNeedByprojectId(String projectId);
    Need getNeed(String id);
}
