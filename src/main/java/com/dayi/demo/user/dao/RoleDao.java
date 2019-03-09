package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author wut
 */
public interface RoleDao {
    int addRole(Role role);
    List<Role> findRole();
    int updateRole(Role role);
    List<Role> findRoleByUserId(String userId);
    int addUserRole(@Param("id") String id, @Param("addTime") Date addTime, @Param("updateTime")Date updateTime
            , @Param("userId")String userId, @Param("roleId")String roleId);
    int deleteUserRole(@Param("userId") String userId,@Param("roleId") String roleId);
    int deleteRole(String id);
}
