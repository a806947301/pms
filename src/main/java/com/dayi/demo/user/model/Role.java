package com.dayi.demo.user.model;

import com.dayi.demo.common.entity.BaseEntity;

import java.util.Date;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-3-10
 */
public class Role extends BaseEntity {
    /** 角色名 */
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static boolean hasEmpty(Role role, boolean includingId) {
        if(BaseEntity.hasEmpty(role, includingId)) {
            return true;
        }
        if(null == role || "".equals(role)) {
            return true;
        }
        return false;
    }
}
