package com.dayi.demo.bug.dao;

import com.dayi.demo.bug.model.BugDescription;

import java.util.List;

/**
 * @Author wut
 */
public interface BugDescriptionDao {

    /**
     * 添加Bug说明
     * @param bugDescription
     * @return
     */
    int addBugDescription(BugDescription bugDescription);

    /**
     * 查找指定Bug的Bug说明
     * @param bugId
     * @return
     */
    List<BugDescription> findByBugId(String bugId);
}
