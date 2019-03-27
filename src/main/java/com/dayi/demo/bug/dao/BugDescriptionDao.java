package com.dayi.demo.bug.dao;

import com.dayi.demo.bug.model.BugDescription;

import java.util.List;

/**
 * Bug说明 dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public interface BugDescriptionDao {

    /**
     * 添加Bug说明
     *
     * @param bugDescription
     * @return
     */
    int add(BugDescription bugDescription);

    /**
     * 查找指定Bug的Bug说明
     *
     * @param bugId
     * @return
     */
    List<BugDescription> findByBugId(String bugId);

    /**
     * 删除指定BugId的所有说明
     *
     * @param bugId
     * @return
     */
    int deleteByBugId(String bugId);
}
