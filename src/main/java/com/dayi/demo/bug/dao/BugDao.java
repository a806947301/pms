package com.dayi.demo.bug.dao;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.statistic.model.vo.ProjectBugVo;
import com.dayi.demo.statistic.model.vo.UserBugVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Bug dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public interface BugDao {
    /**
     * 添加Bug
     *
     * @param bug
     * @return
     */
    int add(Bug bug);

    /**
     * 根据条件查找Bug
     *
     * @param projectId   项目id，null为不筛选
     * @param begin       开始时间，null为不筛选
     * @param end         结束时间，null为不筛选
     * @param status      状态，-1为不筛选
     * @param processerId Bug处理者，null为不筛选
     * @param proposerId  Bug提出者，null为不筛选
     * @return
     */
    List<Bug> findByProject(@Param("projectId") String projectId,
                            @Param("begin") Date begin,
                            @Param("end") Date end,
                            @Param("status") int status,
                            @Param("processerId") String processerId,
                            @Param("proposerId") String proposerId);

    /**
     * 获取指定Bug
     *
     * @param id Bug Id
     * @return
     */
    Bug get(String id);

    /**
     * 更新Bug
     *
     * @param bug
     * @return
     */
    int update(Bug bug);

    /**
     * 统计每个项目Id对应的Bug数
     *
     * @return
     */
    List<ProjectBugVo> countBugByProject();

    /**
     * 统计每个Bug处理者对应的Bug情况
     *
     * @return
     */
    List<UserBugVo> countBugByProcesser();

    /**
     * 统计每个Bug提出者对应的Bug情况
     *
     * @return
     */
    List<UserBugVo> countBugByProposer();

    /**
     * 统计项目下未完成Bug的数量
     *
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
    List<Bug> findByUserDesignee(String userId);

    /**
     * 删除Bug
     *
     * @param id
     * @return
     */
    int delete(String id);
}
