package com.dayi.demo.common.aspect;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugOperatingRecordService;
import com.dayi.demo.bug.service.impl.BugOperetingRecordServiceImpl;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
    UserService userService;

    @Resource
    BugOperatingRecordService recordService;

    /**
     * Bug添加后
     *
     * @param point
     */
    @AfterReturning("execution(* com.dayi.demo.bug.service.impl.BugServiceImpl.add(..))")
    public void afterAdd(JoinPoint point) {
        //获取参数
        Bug bug = (Bug) point.getArgs()[0];
        //设置操作数
        int opetationNumber = (BugOperatingRecord.Operation.DESIGNATE.getValue());
        //添加记录
        addRecord(bug.getId(), opetationNumber, bug.getBugProposer(), bug.getBugProcesser());
    }

    /**
     * Bug重新指派后
     *
     * @param point
     */
    @AfterReturning("execution(* com.dayi.demo.bug.service.impl.BugServiceImpl.doRedesignate(..))")
    public void afterRedesignate(JoinPoint point) {
        //获取参数
        String bugId = (String) point.getArgs()[0];
        String processerId = (String) point.getArgs()[1];
        User currentUser = (User) point.getArgs()[2];
        User processer = userService.get(processerId);
        //设置操作数
        int opetationNumber = (BugOperatingRecord.Operation.DESIGNATE.getValue());
        //添加记录
        addRecord(bugId, opetationNumber, currentUser, processer);
    }

    /**
     * 设置自己处理Bug后
     *
     * @param point
     */
    @AfterReturning("execution(* com.dayi.demo.bug.service.impl.BugServiceImpl.doProcessSelf(..))")
    public void afterProcessSelf(JoinPoint point) {
        //获取参数
        String bugId = (String) point.getArgs()[0];
        User currentUser = (User) point.getArgs()[1];
        //设置操作数
        int operationNumber = BugOperatingRecord.Operation.PROCESS_SELF.getValue();
        //添加记录
        addRecord(bugId, operationNumber, currentUser, null);
    }

    /**
     * 设置不予处理后
     *
     * @param point
     */
    @AfterReturning("execution(* com.dayi.demo.bug.service.impl.BugServiceImpl.doNoProcessing(..))")
    public void afterNoProcessing(JoinPoint point) {
        //获取参数
        String bugId = (String) point.getArgs()[0];
        User currentUser = (User) point.getArgs()[1];
        //设置操作数
        int operationNumber = BugOperatingRecord.Operation.NOT_PROCESS.getValue();
        //添加记录
        addRecord(bugId, operationNumber, currentUser, null);
    }

    /**
     * 关闭Bug后
     *
     * @param point
     */
    @AfterReturning("execution(* com.dayi.demo.bug.service.impl.BugServiceImpl.doCloseBug(..))")
    public void afterClose(JoinPoint point) {
        //获取参数
        String bugId = (String) point.getArgs()[0];
        User currentUser = (User) point.getArgs()[1];
        //设置操作数
        int operationNumber = BugOperatingRecord.Operation.CLOSE_BUG.getValue();
        //添加记录
        addRecord(bugId, operationNumber, currentUser, null);
    }

    /**
     * 添加Bug说明后
     *
     * @param point
     */
    @AfterReturning("execution(* com.dayi.demo.bug.service.impl.BugServiceImpl.addBugDescription(..))")
    public void afterAddDescription(JoinPoint point) {
        //获取参数
        BugDescription bugDescription = (BugDescription) point.getArgs()[0];
        User currentUser = (User) point.getArgs()[1];
        //设置操作数
        int operationNumber = BugOperatingRecord.Operation.ADD_DESCRIPTION.getValue();
        //添加记录
        addRecord(bugDescription.getBugId(), operationNumber, currentUser, null);
    }

    /**
     * 添加Bug记录
     *
     * @param bugId
     * @param operationNumber
     * @param user
     * @param operationUser
     */
    private void addRecord(String bugId, int operationNumber, User user, User operationUser) {
        BugOperatingRecord record = packageRecord(bugId, operationNumber, user, operationUser);
        try {
            recordService.add(record);
        } catch (Exception e) {
            logger.error(BugOperatingRecordService.class.toString() + "_" + e.getMessage(), e);
        }
    }


    /**
     * 打包Bug记录
     *
     * @param bugId           bug
     * @param operationNumber bug操作数
     * @param user            操作人
     * @param operationUser   操作对象
     * @return
     */
    private BugOperatingRecord packageRecord(String bugId, int operationNumber, User user, User operationUser) {
        BugOperatingRecord record = new BugOperatingRecord();
        record.setBugId(bugId);
        record.setOperationNumber(operationNumber);
        record.setUser(user);
        if (null == operationUser) {
            operationUser = new User();
            operationUser.setId("");
        }
        record.setOperationUser(operationUser);
        return record;
    }


}
