package com.dayi.demo.bug.model;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.user.model.User;

import java.util.Date;

/**
 * Bug记录 POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public class BugOperatingRecord extends BaseEntity {

    public enum Operation {
        /**
         * 指派
         */
        DESIGNATE(0),
        /**
         * 设置自己处理
         */
        PROCESS_SELF(1),
        /**
         * 设置不予处理
         */
        NOT_PROCESS(2),
        /**
         * 添加Bug说明
         */
        ADD_DESCRIPTION(3),
        /**
         * 关闭Bug
         */
        CLOSE_BUG(4);

        private final int value;

        Operation(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

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
