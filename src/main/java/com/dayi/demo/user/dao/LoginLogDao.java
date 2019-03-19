package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.LoginLog;

import java.util.List;

/**
 * 登陆日志dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-08
 */
public interface LoginLogDao {

    /**
     * 添加登陆日志
     * @param loginLog
     * @return
     */
    int add(LoginLog loginLog);

    /**
     * 查找指定用户的登陆日志
     * @param userId
     * @return
     */
    List<LoginLog> findLoginLogByUserId(String userId);
}
