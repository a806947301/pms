package com.dayi.demo.common.user.model;

import java.util.Date;

/**
 * @Author wut
 */
public class User {
    /** id */
    private String id;
    /** 添加时间 */
    private Date addTime;
    /** 更新时间 */
    private Date updateTime;
    /** 姓名 */
    private String name;
    /** 部门编号 */
    private String departmentId;
    /** 工号 */
    private int jobNumber;
    /** 邮箱 */
    private String email;
    /** 密码 */
    private String password;

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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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
}
