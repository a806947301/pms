package com.dayi.demo.bug.dao;

import com.dayi.demo.bug.model.Bug;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public interface BugDao {
    /**
     * 添加Bug
     * @param bug
     * @return
     */
    int addBug(Bug bug);

    /**
     * 根据条件查找Bug
     * @param projectId 项目id，null为不筛选
     * @param begin 开始时间，null为不筛选
     * @param end   结束时间，null为不筛选
     * @param status    状态，-1为不筛选
     * @param processerId   Bug处理者，null为不筛选
     * @param proposerId    Bug提出者，null为不筛选
     * @return
     */
    List<Bug> findBugByProject(@Param("projectId") String projectId,
                               @Param("begin") Date begin,
                               @Param("end") Date end,
                               @Param("status") int status,
                               @Param("processerId") String processerId,
                               @Param("proposerId") String proposerId);

    /**
     * 获取指定Bug
     * @param id    Bug Id
     * @return
     */
    Bug getBug(String id);

    /**
     * 更新Bug的状态
     * @param id    Bug Id
     * @param bugStatus Bug 状态
     * @param bugProcesser  Bug 处理者
     * @param noProcessing  不处理Bug
     * @param updateTime    更新时间
     * @return
     */
    int updateBugStatue(@Param("id") String id,
                        @Param("bugStatus") int bugStatus,
                        @Param("bugProcesser") String bugProcesser,
                        @Param("noProcessing") boolean noProcessing,
                        @Param("updateTime") Date updateTime);

    /**
     * 统计每个项目Id对应的Bug数
     * @return
     */
    List<Map<String, Object>> countBugByProject();

    /**
     * 统计每个Bug处理者对应的Bug情况
     * @return
     */
    List<Map<String,Object>> countBugByProcesser();

    /**
     * 统计每个Bug提出者对应的Bug情况
     * @return
     */
    List<Map<String,Object>> countBugByProposer();

    /**
     * 统计项目下未完成Bug的数量
     * @param projectId
     * @return
     */
    int countBugByProjectNoFinished(String projectId);

    /**
     * 查找用户被指派的Bug
     *
     * @param userId
     * @return
     */
    List<Bug> findBugByUserDesignee(String userId);
}
