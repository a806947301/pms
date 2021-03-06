package com.dayi.demo.common.entity;

import java.util.Date;

/**
 * 所有数据库实体的基类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-18
 */
public class BaseEntity {
    /**
     * id
     */
    protected String id;
    /**
     * 添加时间
     */
    protected Date addTime;
    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 判断字段是否有空
     * @param entity
     * @param includeId
     * @return
     */
    public static boolean hasEmpty(BaseEntity entity, boolean includeId) {
        if (null == entity) {
            return true;
        }
        boolean emptyId = null == entity.getId() || "".equals(entity.getId());
        if (includeId && emptyId) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

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


}
