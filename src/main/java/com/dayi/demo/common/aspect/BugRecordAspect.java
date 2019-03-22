package com.dayi.demo.common.aspect;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.strategy.BugStatusStrategy;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Bug记录切面，给Bug添加操作记录
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-18
 */
@Component
@Aspect
public class BugRecordAspect {

    @Resource
    private List<BugStatusStrategy> bugStatusStrategies;

    /**
     * Bug状态更新后
     * @param point
     * @param bug
     * @throws SystemException
     */
    @AfterReturning(returning = "bug",
            value = "execution(* com.dayi.demo.bug.service.impl.BugServiceImpl.updateStatus(..))")
    public void afterUpdateStatus(JoinPoint point, Bug bug) throws SystemException {
        //获取当前用户
        User currentUser = (User) point.getArgs()[1];
        //获取状态处理策略
        int status = bug.getBugStatus();
        BugStatusStrategy statusStrategy = bugStatusStrategies.get(status);
        //添加Bug记录
        statusStrategy.addRecord(bug, currentUser);
        //发送邮件
        statusStrategy.sendEmail(bug);
    }
}
