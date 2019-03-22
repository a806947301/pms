package com.dayi.demo.bug.strategy.impl;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugOperatingRecordService;
import com.dayi.demo.bug.strategy.BugStatusStrategy;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Bug状态改变策略之：自己处理策略
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-22
 */
@Order(2)
@Component
public class ProcessSelfStategy implements BugStatusStrategy {

    @Resource
    private BugOperatingRecordService recordService;

    @Override
    public Bug update(Bug bug, Bug oldBug, User currentUser) throws SystemException {
        // 是否合法处理者 （Bug状态为指派中，且Bug的处理者为当前用户）
        boolean isLegalProcesser = oldBug.getBugStatus() == Bug.Status.DESIGNATE.getValue() &&
                oldBug.getBugProcesser().getId().equals(currentUser.getId());
        if (!isLegalProcesser) {
            throw new SystemException("非法操作");
        }
        return bug;
    }

    @Override
    public void addRecord(Bug bug, User currentUser) throws SystemException {
        //新建Bug操作记录实体
        BugOperatingRecord record = new BugOperatingRecord();
        record.setUser(currentUser);
        record.setBugId(bug.getId());
        record.setOperationUser(new User(""));
        record.setOperationNumber(BugOperatingRecord.Operation.PROCESS_SELF.getValue());
        //保存记录
        recordService.add(record);
    }

    @Override
    public boolean sendEmail(Bug bug) throws SystemException {
        return false;
    }
}
