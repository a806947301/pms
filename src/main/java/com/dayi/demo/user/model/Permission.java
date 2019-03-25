package com.dayi.demo.user.model;

import com.dayi.demo.common.entity.BaseEntity;


/**
 * 权限 POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-3-6
 */
public class Permission extends BaseEntity {
    /**
     * 权限名
     */
    private String permissionName;
    /**
     * 权限字段
     */
    private String field;
    /**
     * 是否菜单
     */
    private Boolean menu;
    /**
     * 父级菜单id
     */
    private String parentId;

    @Override
    public String toString() {
        return "Permission{" +
                "permissionName='" + permissionName + '\'' +
                ", field='" + field + '\'' +
                ", menu=" + menu +
                ", parentId='" + parentId + '\'' +
                ", id='" + id + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    /**
     * 判断是否有字段为空
     *
     * @param p
     * @param includeId
     * @return
     */
    public static boolean hasEmpty(Permission p, boolean includeId) {
        if (BaseEntity.hasEmpty(p, includeId)) {
            return true;
        }
        if (null == p.getPermissionName() || "".equals(p.getPermissionName())) {
            return true;
        }
        if (null == p.getField() || "".equals(p.getField())) {
            return true;
        }
        return false;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Boolean getMenu() {
        return menu;
    }

    public void setMenu(Boolean menu) {
        this.menu = menu;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


}
