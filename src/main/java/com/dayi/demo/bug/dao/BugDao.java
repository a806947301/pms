package com.dayi.demo.bug.dao;

import com.dayi.demo.bug.model.Bug;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author wut
 */
public interface BugDao {
    int addBug(Bug bug);
    List<Bug> findBugByProject(@Param("projectId") String projectId,@Param("begin") Date begin,@Param("end")Date end,
                               @Param("status")int status,@Param("processerId")String processerId,@Param("proposerId")String proposerId);
    Bug getBug(String id);
    int updateBugStatue(@Param("id") String id, @Param("bugStatus")int bugStatus, @Param("bugProcesser") String bugProcesser,
                        @Param("noProcessing") boolean noProcessing,@Param("updateTime") Date updateTime);
}
