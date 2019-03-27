package com.dayi.demo.bug.dao;

import com.dayi.demo.bug.model.BugOperatingRecord;

import java.util.List;

/**
 * Bug操作记录 dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public interface BugOperatingRecordDao {

    /**
     * 添加Bug操作记录
     *
     * @param record
     * @return
     */
    int addBugOperatingRecord(BugOperatingRecord record);

    /**
     * 查找指定Bug的Bug操作记录
     *
     * @param bugId
     * @return
     */
    List<BugOperatingRecord> findBugOperatingRecordByBugId(String bugId);

    /**
     * 删除指定BugId的Bug操作记录
     *
     * @param bugId
     * @return
     */
    int deleteByBugId(String bugId);
}
