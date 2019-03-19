package com.dayi.demo.bug.service.impl;

import com.dayi.demo.bug.dao.BugOperatingRecordDao;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugOperatingRecordService;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Bug操作记录模块Service层实现类
 *
 * @author WuTong<wut   @   pvc123.com>
 * @date 2019-03-18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BugOperetingRecordServiceImpl implements BugOperatingRecordService {

    @Resource
    private BugOperatingRecordDao bugOperatingRecordDao;

    @Resource
    private UserService userService;

    @Override
    public PageInfo<BugOperatingRecord> findByBugId(String bugId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<BugOperatingRecord> list = bugOperatingRecordDao.findBugOperatingRecordByBugId(bugId);
        PageInfo<BugOperatingRecord> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @Override
    public void add(BugOperatingRecord record) throws SystemException {
        bugOperatingRecordDao.addBugOperatingRecord(record);
    }
}
