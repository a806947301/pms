package com.dayi.demo.user.model;

import java.util.Date;

/**
 * @Author wut
 */
public class Premission {
    /** id */
    private String id;
    /** 添加时间 */
    private Date addTime;
    /** 更新时间 */
    private Date updateTime;
    /** 权限名 */
    private String premissionName;
    /** 权限字段 */
    private String field;
    /** 是否菜单 */
    private boolean menu;
    /** 父级菜单id */
    private String parentId;

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

    public String getPremissionName() {
        return premissionName;
    }

    public void setPremissionName(String premissionName) {
        this.premissionName = premissionName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
