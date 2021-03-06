package com.dayi.demo.user.model;

import com.dayi.demo.common.entity.BaseEntity;


/**
 * 登陆日志 POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-08
 */
public class LoginLog extends BaseEntity {
    /**
     * 登陆ip地址
     */
    private String ip;
    /**
     * 登陆用户
     */
    private User user;

    @Override
    public String toString() {
        return "LoginLog{" +
                "ip='" + ip + '\'' +
                ", user=" + user +
                ", id='" + id + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
