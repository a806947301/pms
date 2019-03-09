package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.LoginLog;

import java.util.List;

/**
 * @Author wut
 * @Date 2019-03-08
 */
public interface LoginLogDao {
    int addLoginLog(LoginLog loginLog);
    List<LoginLog> findLoginLogByUserId(String userId);
}
