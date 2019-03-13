package com.dayi.demo.user.dao;


import com.dayi.demo.user.model.Premission;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-3-6
 */
public interface PremissionDao {

    /**
     * 添加权限
     * @param premission
     * @return
     */
    int addPremission(Premission premission);

    /**
     * 查找权限
     * @return
     */
    List<Premission> findPremission();

    /**
     * 根据是否菜单查找权限
     * @param isMenu
     * @return
     */
    List<Premission> findByIsMenu(boolean isMenu);

    /**
     * 更新权限
     * @param premission
     * @return
     */
    int updatePremission(Premission premission);

    /**
     * 查找指定角色下的所有权限
     * @param roleId
     * @return
     */
    List<Premission> findByRoleId(String roleId);

    /**
     * 给角色授权
     * @param id    角色权限表Id，从IdUtil获取
     * @param addTime   添加时间
     * @param updateTime    修改时间
     * @param roleId    角色Id
     * @param premissionId  权限Id
     * @return
     */
    int addRolePremission(@Param("id") String id, @Param("addTime") Date addTime, @Param("updateTime") Date updateTime,
                          @Param("roleId") String roleId, @Param("premissionId") String premissionId);

    /**
     * 取消角色权限
     * @param roleId    角色Id
     * @param premissionId  权限Id
     * @return
     */
    int deleteRolePremission(@Param("roleId") String roleId, @Param("premissionId") String premissionId);

    /**
     * 删除权限
     * @param id
     * @return
     */
    int deletePremission(String id);

}
