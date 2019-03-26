package com.dayi.demo.bug.strategy.impl;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugOperatingRecordService;
import com.dayi.demo.bug.strategy.BugStatusStrategy;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Bug状态改变策略之：指派策略
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-22
 */
@Order(1)
@Component
public class DesignateStrategy implements BugStatusStrategy {

    private final static Logger logger = LoggerFactory.getLogger(DesignateStrategy.class);

    @Resource
    private BugOperatingRecordService recordService;

    @Override
    public Bug update(Bug bug, Bug oldBug, User currentUser) throws SystemException {
        //提取Bug状态、Bug提出者Id、Bug处理者Id、当前用户Id
        int status = oldBug.getBugStatus();
        String processerId = oldBug.getBugProcesser().getId();
        String proposerId = oldBug.getBugProposer().getId();
        String currentUserId = currentUser.getId();
        // 是否合法处理者 （Bug状态为指派中，且Bug的处理者为当前用户）
        boolean isLegalProcesser = (status == Bug.Status.DESIGNATE.getValue() && currentUserId.equals(processerId));

        // 是否第一种合法提出者 （Bug状态为验收中，且Bug提出者为当前用户）
        boolean isLegalProposer1 = (status == Bug.Status.CHECKING.getValue() && currentUserId.equals(proposerId));

        // 是否是第二种合法提出者 （Bug状态为指派中，且Bug提出者为当前用户）
        boolean isLegalProposer2 = (status == Bug.Status.DESIGNATE.getValue() && currentUserId.equals(proposerId));

        //如果以上合法人员都不是，则为不合法人员
        if (!(isLegalProcesser || isLegalProposer1 || isLegalProposer2)) {
            throw new SystemException("违法操作");
        }

        //改变Bug不予处理状态
        bug.setNoProcessing(false);
        return bug;
    }

    @Override
    public void addRecord(Bug bug, User currentUser) throws SystemException {
        //新建Bug操作记录实体
        BugOperatingRecord record = new BugOperatingRecord();
        record.setUser(currentUser);
        record.setOperationUser(bug.getBugProcesser());
        record.setBugId(bug.getId());
        record.setOperationNumber(BugOperatingRecord.Operation.DESIGNATE.getValue());
        //添加操作记录
        recordService.add(record);
    }

    @Override
    public boolean sendEmail(Bug bug) throws SystemException {
        //获取邮件发送的对象邮箱
        User processer = bug.getBugProcesser();
        String email = processer.getEmail();
        String title = "您被指派一个Bug";
        String content = "请您登陆主页查看自己被指派的Bug，Bug Id为：" + bug.getId() +
                "\nbug标题为：" + bug.getBugTitle();
        try {
            MailUtil.sendMail(email, title, content);
        } catch (Exception e) {
            logger.error(DesignateStrategy.class.toString() + "_" + e.getMessage(), e);
            return false;
        }
        return true;
    }
}
