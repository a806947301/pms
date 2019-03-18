package com.dayi.demo.bug.model;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.user.model.User;

import java.util.Date;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public class BugOperatingRecord extends BaseEntity {

    /** 所属Bug id */
    private String bugId;
    /** 操作人 */
    private User user;
    /** 操作数 */
    private int operationNumber;
    /** 操作对象 */
    private User operationUser;

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
