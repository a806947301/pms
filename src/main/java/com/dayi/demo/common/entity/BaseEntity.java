package com.dayi.demo.common.entity;

import java.util.Date;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-03-18
 */
public abstract class BaseEntity {
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

    public static boolean hasEmpty(BaseEntity entity, boolean includeId) {
        if (null == entity) {
            return true;
        }
        if (includeId && (null == entity.getId() || "".equals(entity.getId()))) {
            return true;
        }
        return false;
    }
}
