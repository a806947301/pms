package com.dayi.demo.user.model;

import java.util.Date;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-22
 */
public class Department {
    /** id */
    private String id;
    /** 添加时间 */
    private Date addTime;
    /** 更新时间 */
    private Date updateTime;
    /** 部门名 */
    private String departmentName;

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
