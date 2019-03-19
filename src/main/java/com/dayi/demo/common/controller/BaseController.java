package com.dayi.demo.common.controller;

import com.dayi.demo.user.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * 所有controller的基类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-18
 */
public abstract class BaseController {
    /**
     * 获取当前用户
     *
     * @return
     */
    public User getCurrentUser() {
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }
}
