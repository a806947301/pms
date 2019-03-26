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
 * Bug状态改变策略之：验收策略
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-22
 */
@Order(2)
@Component
public class CheckingStrategy implements BugStatusStrategy {

    private final static Logger logger = LoggerFactory.getLogger(CheckingStrategy.class);

    @Resource
    private BugOperatingRecordService recordService;

    @Override
    public Bug update(Bug bug, Bug oldBug, User currentUser) throws SystemException {
        //提取Bug状态、处理者Id、当前用户Id
        int status = oldBug.getBugStatus();
        String processerId = oldBug.getBugProcesser().getId();
        String currentUserId = currentUser.getId();

        // 是否合法处理者 （Bug状态为处理中，且Bug的处理者为当前用户）
        boolean isLegalProcesser = (status == Bug.Status.DESIGNATE.getValue() && currentUserId.equals(processerId));
        if (!isLegalProcesser) {
            throw new SystemException("非法操作");
        }
        return bug;
    }

    @Override
    public void addRecord(Bug bug, User currentUser) throws SystemException {
        //判断操作类型
        int operationNumber;
        if (null != bug.getNoProcessing() && bug.getNoProcessing()) {
            operationNumber = BugOperatingRecord.Operation.NOT_PROCESS.getValue();
        } else {
            operationNumber = BugOperatingRecord.Operation.ADD_DESCRIPTION.getValue();
        }

        //新建Bug操作记录实体
        BugOperatingRecord record = new BugOperatingRecord();
        record.setUser(currentUser);
        record.setBugId(bug.getId());
        record.setOperationNumber(operationNumber);
        record.setOperationUser(new User(""));
        //保存记录
        recordService.add(record);
    }

    @Override
    public boolean sendEmail(Bug bug) throws SystemException {
        //获取邮件发送的对象邮箱
        String email = bug.getBugProposer().getEmail();
        String title = "您的Bug已被处理完毕，请验收";
        String content = "您的Bug已被处理完毕，请验收。" +
                "\nBug为id：" + bug.getId() +
                "\nBug标题为：" + bug.getBugTitle();
        try {
            MailUtil.sendMail(email, title, content);
        } catch (Exception e) {
            logger.error(CheckingStrategy.class.toString() + "_" + e.getMessage(), e);
            return false;
        }
        return true;
    }
}
