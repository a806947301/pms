package com.dayi.demo.bug.strategy.impl;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugOperatingRecordService;
import com.dayi.demo.bug.strategy.BugStatusStrategy;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;
import com.dayi.demo.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Bug状态改变策略之：关闭策略
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-22
 */
@Order(3)
@Component
public class CloseStrategy implements BugStatusStrategy {

    private final static Logger logger = LoggerFactory.getLogger(CloseStrategy.class);

    @Resource
    private BugOperatingRecordService recordService;

    @Override
    public Bug update(Bug bug, Bug oldBug, User currentUser) throws SystemException {
        //提取Bug状态、Bug提出者Id、当前用户Id
        int status = oldBug.getBugStatus();
        String proposerId = oldBug.getBugProposer().getId();
        String currentUserId = currentUser.getId();

        //是否合法Bug提出者 （Bug状态为验收中，且Bug提出者为当前用户）
        boolean isLegalProposer = (Bug.Status.CHECKING.getValue() == status && currentUserId.equals(proposerId));
        if (!isLegalProposer) {
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
        record.setOperationNumber(BugOperatingRecord.Operation.CLOSE_BUG.getValue());
        //保存记录
        recordService.add(record);
    }

    @Override
    public boolean sendEmail(Bug bug) throws SystemException {
        //获取邮件发送的对象邮箱
        String email = bug.getBugProcesser().getEmail();
        String title = "您的Bug已完成";
        String content = "您的Bug已完成。" +
                "\nBug为id：" + bug.getId() +
                "\nBug标题为：" + bug.getBugTitle();
        try {
            MailUtil.sendMail(email, title, content);
        } catch (Exception e) {
            logger.error(CloseStrategy.class.toString() + "_" + e.getMessage(), e);
            return false;
        }
        return true;
    }
}
