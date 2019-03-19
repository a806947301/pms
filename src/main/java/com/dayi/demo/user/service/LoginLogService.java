package com.dayi.demo.user.service;

import com.dayi.demo.user.model.LoginLog;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


/**
 * 登陆日志模块Service层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-08
 */
@Service
public interface LoginLogService {
    /**
     * 添加登陆日志
     *
     * @param loginLog
     * @return
     */
    int add(LoginLog loginLog);

    /**
     * 查找指定用户的登陆日志
     *
     * @param userId
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo<LoginLog> findLoginLogByUserId(String userId, int currentPage, int pageSize);
}
