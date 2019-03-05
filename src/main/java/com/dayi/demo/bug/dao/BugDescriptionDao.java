package com.dayi.demo.bug.dao;

import com.dayi.demo.bug.model.BugDescription;

import java.util.List;

/**
 * @Author wut
 */
public interface BugDescriptionDao {
    int addBugDescription(BugDescription bugDescription);
    List<BugDescription> findByBugId(String bugId);
}
