package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author wut
 */
public interface RoleDao {

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 查找角色
     * @return
     */
    List<Role> findRole();

    /**
     * 更新角色
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 查找指定用户的角色
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(String userId);

    /**
     * 给用户赋予角色
     * @param id    用户角色表Id，从IdUtil获取
     * @param addTime   添加时间
     * @param updateTime    更新时间
     * @param userId    用户Id
     * @param roleId    角色Id
     * @return
     */
    int addUserRole(@Param("id") String id, @Param("addTime") Date addTime, @Param("updateTime") Date updateTime,
                    @Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 取消用户角色
     * @param userId    用户Id
     * @param roleId    角色Id
     * @return
     */
    int deleteUserRole(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 删除角色
     * @param id
     * @return
     */
    int deleteRole(String id);
}
