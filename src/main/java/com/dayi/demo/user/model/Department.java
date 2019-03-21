package com.dayi.demo.user.model;

import com.dayi.demo.common.entity.BaseEntity;


/**
 * 部门 POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-22
 */
public class Department extends BaseEntity {

    /**
     * 部门名
     */
    private String departmentName;

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }

    /**
     * 判断等部门是否有空字段
     * @param department
     * @param includeId
     * @return
     */
    public static boolean hasEmpty(Department department, boolean includeId) {
        if (BaseEntity.hasEmpty(department, includeId)) {
            return true;
        }
        if (null == department.getDepartmentName() || "".equals(department.getDepartmentName())) {
            return true;
        }
        return false;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
