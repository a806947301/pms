package com.dayi.demo.user.dao;


import com.dayi.demo.user.model.Premission;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author wut
 */
public interface PremissionDao {
    int addPremission(Premission premission);
    List<Premission> findPremission();
    List<Premission> findByIsMenu(boolean isMenu);
    int updatePremission(Premission premission);
    List<Premission> findByRoleId(String roleId);
    int addRolePremission(@Param("id") String id,@Param("addTime") Date addTime, @Param("updateTime")Date updateTime
            , @Param("roleId")String roleId, @Param("premissionId")String premissionId);
    int deleteRolePremission(@Param("roleId") String roleId,@Param("premissionId") String premissionId);
    int deletePremission(String id);

}
