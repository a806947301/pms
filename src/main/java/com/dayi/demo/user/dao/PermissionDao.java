package com.dayi.demo.user.dao;


import com.dayi.demo.user.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 权限dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-3-6
 */
public interface PermissionDao {

    /**
     * 添加权限
     * @param permission
     * @return
     */
    int add(Permission permission);

    /**
     * 查找权限
     * @return
     */
    List<Permission> findPermission();

    /**
     * 根据是否菜单查找权限
     * @param isMenu
     * @return
     */
    List<Permission> findByIsMenu(boolean isMenu);

    /**
     * 更新权限
     * @param permission
     * @return
     */
    int update(Permission permission);

    /**
     * 查找指定角色下的所有权限
     * @param roleId
     * @return
     */
    List<Permission> findByRoleId(String roleId);

    /**
     * 给角色授权
     * @param id    角色权限表Id，从IdUtil获取
     * @param addTime   添加时间
     * @param updateTime    修改时间
     * @param roleId    角色Id
     * @param permissionId  权限Id
     * @return
     */
    int addRolePermission(@Param("id") String id, @Param("addTime") Date addTime, @Param("updateTime") Date updateTime,
                          @Param("roleId") String roleId, @Param("permissionId") String permissionId);

    /**
     * 取消角色权限
     * @param roleId    角色Id
     * @param permissionId  权限Id
     * @return
     */
    int deleteRolePermission(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

    /**
     * 删除权限
     * @param id
     * @return
     */
    int delete(String id);

}
