package com.dayi.demo.user.model;

import com.dayi.demo.common.entity.BaseEntity;


/**
 * 角色 POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-3-10
 */
public class Role extends BaseEntity {
    /**
     * 角色名
     */
    private String roleName;

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }

    /**
     * 判断角色是否有空字段
     * @param role
     * @param includingId
     * @return
     */
    public static boolean hasEmpty(Role role, boolean includingId) {
        if (BaseEntity.hasEmpty(role, includingId)) {
            return true;
        }
        if (null == role || "".equals(role)) {
            return true;
        }
        return false;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
