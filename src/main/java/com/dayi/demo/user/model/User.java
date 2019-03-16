package com.dayi.demo.user.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
public class User {
    /**
     * id
     */
    private String id;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 姓名
     */
    private String name;
    /**
     * 工号
     */
    private int jobNumber;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private transient String password;
    /**
     * 部门
     */
    private Department department;
    /**
     * 已停用
     */
    private boolean stopped;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User(String id) {
        this.id = id;
    }

    public User() {
    }

    /**
     * 判断User表是否有字段为空
     *
     * @param user
     * @param includeId 是否包含查询id为空
     * @return
     */
    public static boolean hasEmpty(User user, boolean includeId) {
        if (null == user) {
            return true;
        }
        if (user.getName() == null || "".equals(user.getName())) {
            return true;
        }
        if (includeId && (null == user.getId() || "".equals(user.getId()))) {
            return true;
        }
        if (null == user.getPassword() || "".equals(user.getPassword())) {
            return true;
        }
        if (null == user.getEmail() || "".equals(user.getEmail())) {
            return true;
        }
        if (null == user.getDepartment()) {
            return true;
        }
        if (user.getDepartment().getId() == null || "".equals(user.getDepartment().getId())) {
            return true;
        }
        return false;
    }
}
