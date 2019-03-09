package com.dayi.demo.user.model;

import java.util.Date;

/**
 * @Author wut
 * @Date 2019-03-08
 */
public class LoginLog {
    /** id */
    private String id;
    /** 添加时间 */
    private Date addTime;
    /** 更新时间 */
    private transient Date updateTime;
    /** 登陆ip地址 */
    private String ip;
    /** 登陆用户 */
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
