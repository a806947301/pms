package com.dayi.demo.bug.strategy;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;

import javax.mail.MessagingException;

/**
 * Bug状态策略接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-22
 */
public interface BugStatusStrategy {
    /**
     * 更新Bug状态
     *
     * @param bug
     * @param oldBug
     * @param currentUser
     * @return
     * @throws SystemException
     */
    Bug update(Bug bug, Bug oldBug, User currentUser) throws SystemException;

    /**
     * 发送邮件
     *
     * @param bug
     * @throws MessagingException
     */
    void sendEmail(Bug bug) throws MessagingException;

    /**
     * 添加Bug记录
     *
     * @param bug
     * @param currentUser
     * @throws SystemException
     */
    void addRecord(Bug bug, User currentUser) throws SystemException;
}
