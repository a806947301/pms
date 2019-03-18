package com.dayi.demo.user.model;

import com.dayi.demo.common.entity.BaseEntity;

import java.util.Date;

/**
 * @author WuTong<wut       @       pvc123.com>
 * @date 2019-3-6
 */
public class Premission extends BaseEntity {
    /**
     * 权限名
     */
    private String premissionName;
    /**
     * 权限字段
     */
    private String field;
    /**
     * 是否菜单
     */
    private boolean menu;
    /**
     * 父级菜单id
     */
    private String parentId;

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

    /**
     * 判断是否有字段为空
     *
     * @param p
     * @param includeId
     * @return
     */
    public static boolean hasEmpty(Premission p, boolean includeId) {
        if (BaseEntity.hasEmpty(p, includeId)) {
            return true;
        }
        if (null == p.getPremissionName() || "".equals(p.getPremissionName())) {
            return true;
        }
        if (null == p.getField() || "".equals(p.getField())) {
            return true;
        }
        return false;
    }
}
