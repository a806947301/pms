package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.LoginLog;

import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-08
 */
public interface LoginLogDao {

    /**
     * 添加登陆日志
     * @param loginLog
     * @return
     */
    int addLoginLog(LoginLog loginLog);

    /**
     * 查找指定用户的登陆日志
     * @param userId
     * @return
     */
    List<LoginLog> findLoginLogByUserId(String userId);
}
