package com.dayi.demo.common.aspect;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.strategy.BugStatusStrategy;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;

/**
 * Bug记录切面，给Bug添加操作记录
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-18
 */
@Component
@Aspect
public class BugRecordAspect {

    private final static Logger logger = LoggerFactory.getLogger(BugRecordAspect.class);

    @Resource
    private List<BugStatusStrategy> bugStatusStrategies;

    @Resource
    TaskExecutor taskExecutor;

    /**
     * Bug记录修改切入点
     */
    @Pointcut("execution(* com.dayi.demo.bug.service.impl.BugServiceImpl.updateStatus(..))")
    public void updateStatusPointCut() {}

    /**
     * 在Bug记录修改切入点返回后增强：添加Bug记录、发送邮件
     *
     * @param point
     * @param bug   更新状态方法返回的Bug
     * @throws SystemException
     */
    @AfterReturning(returning = "bug", value = "updateStatusPointCut()")
    public void afterUpdateStatus(JoinPoint point, final Bug bug) throws SystemException {
        //获取当前用户
        User currentUser = (User) point.getArgs()[1];
        //获取状态处理策略
        int status = bug.getBugStatus();
        final BugStatusStrategy statusStrategy = bugStatusStrategies.get(status);
        //添加Bug记录
        statusStrategy.addRecord(bug, currentUser);
        //发送邮件
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    statusStrategy.sendEmail(bug);
                } catch (MessagingException e) {
                    //添加错误日志
                    if (logger.isErrorEnabled()) {
                        logger.error(bug.toString() + "_" + e.getMessage(), e);
                    }
                }
            }
        });

    }
}
