package com.dayi.demo.bug.service;

import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.common.exception.SystemException;
import com.github.pagehelper.PageInfo;

/**
 * bug操作记录模块Service层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-18
 */
public interface BugOperatingRecordService {

    /**
     * 分页查找Bug操作记录
     *
     * @param bugId
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<BugOperatingRecord> findByBugId(String bugId, int currentPage, int pageSize);

    /**
     * 添加Bug操作记录
     *
     * @param record
     * @throws SystemException
     */
    void add(BugOperatingRecord record) throws SystemException;

    /**
     * 删除指定BugId的Bug操作记录
     *
     * @param bugId
     */
    void deleteByBugId(String bugId);
}
