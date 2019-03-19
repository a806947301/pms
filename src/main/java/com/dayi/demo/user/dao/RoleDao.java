package com.dayi.demo.user.dao;

import com.dayi.demo.user.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-3-10
 */
public interface RoleDao {

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    int add(Role role);

    /**
     * 查找角色
     *
     * @return
     */
    List<Role> find();

    /**
     * 更新角色
     *
     * @param role
     * @return
     */
    int update(Role role);

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 查找用户角色表的角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    List<Role> findByUserRole(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 给用户赋予角色
     *
     * @param id         用户角色表Id，从IdUtil获取
     * @param addTime    添加时间
     * @param updateTime 更新时间
     * @param userId     用户Id
     * @param roleId     角色Id
     * @return
     */
    int addUserRole(@Param("id") String id, @Param("addTime") Date addTime, @Param("updateTime") Date updateTime,
                    @Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 取消用户角色
     *
     * @param userId 用户Id
     * @param roleId 角色Id
     * @return
     */
    int deleteUserRole(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 获取指定角色名的角色
     *
     * @param roleName
     * @return
     */
    Role getByRoleName(String roleName);

    /**
     * 获取指定角色
     *
     * @param id
     * @return
     */
    Role get(String id);
}
