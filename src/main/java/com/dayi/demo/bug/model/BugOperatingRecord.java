package com.dayi.demo.bug.model;

import com.dayi.demo.user.model.User;

import java.util.Date;

/**
 * @Author wut
 */
public class BugOperatingRecord {
    /** id */
    private String id;
    /** 创建时间 */
    private Date addTime;
    /** 更新时间 */
    private Date updateTime;
    /** 所属Bug id */
    private String bugId;
    /** 操作人 */
    private User user;
    /** 操作数 */
    private int operationNumber;
    /** 操作对象 */
    private User operationUser;

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

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(int operationNumber) {
        this.operationNumber = operationNumber;
    }

    public User getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(User operationUser) {
        this.operationUser = operationUser;
    }
}
