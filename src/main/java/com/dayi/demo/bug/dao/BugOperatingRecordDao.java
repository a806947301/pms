package com.dayi.demo.bug.dao;

import com.dayi.demo.bug.model.BugOperatingRecord;

import java.util.List;

/**
 * @Author wut
 */
public interface BugOperatingRecordDao {
    int addBugOperatingRecord(BugOperatingRecord record);
    List<BugOperatingRecord> findBugOperatingRecordByBugId(String bugId);
}
