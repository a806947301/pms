package com.dayi.demo.bug.service;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.statistic.model.vo.ProjectBugVo;
import com.dayi.demo.statistic.model.vo.UserBugVo;
import com.dayi.demo.user.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * Bug模块Service层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public interface BugService {

    /**
     * 添加bug
     *
     * @param bug
     * @param currentUser
     * @return
     * @throws SystemException
     */
    String add(Bug bug, User currentUser) throws SystemException;

    /**
     * 上传bug图片
     *
     * @param file      图片文件
     * @param projectId 项目id
     * @param realPath  webapp地址
     * @return
     */
    Map<String, String> doBugImgUpload(MultipartFile file, String projectId, String realPath);

    /**
     * 分页并筛选查看产品下的Bug
     *
     * @param currentPage 当前页
     * @param pageSize    每页的size
     * @param projectId   项目id，null为不筛选
     * @param begin       开始时间，null为不筛选
     * @param end         结束时间，null为不筛选
     * @param status      状态，-1为不筛选
     * @param processerId Bug处理者，null为不筛选
     * @param proposerId  Bug提出者，null为不筛选
     * @return
     */
    PageInfo<Bug> findByProject(int currentPage, int pageSize, String projectId, Date begin,
                                   Date end, int status, String processerId, String proposerId);

    /**
     * 根据id获取Bug
     *
     * @param id
     * @return
     */
    Bug get(String id);

    /**
     * 更新Bug状态
     *
     * @param bug
     * @param currentUser
     * @return  返回更新后的Bug
     * @throws SystemException
     */
    Bug updateStatus(Bug bug, User currentUser) throws SystemException;

    /**
     * 添加Bug说明
     *
     * @param bugDescription
     * @param currentUser
     * @throws SystemException
     */
    void addBugDescription(BugDescription bugDescription, User currentUser) throws SystemException;

    /**
     * 分页查找Bug说明
     *
     * @param bugId
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<BugDescription> findDescriptionByBugId(String bugId, int currentPage, int pageSize);

    /**
     * 统计所有项目下的Bug量
     *
     * @return  返回<项目Id：项目Bug Vo>对应map
     */
    Map<String, ProjectBugVo> countBugByProject();

    /**
     * 统计每个开发的Bug量
     *
     * @return  返回<用户Id：用户Bug Vo>对应map
     */
    Map<String, UserBugVo> countBugByProcesser();

    /**
     * 统计每个测试的Bug量
     *
     * @return
     */
    Map<String, UserBugVo> countBugByProposer();

    /**
     * 统计项目下未完成Bug的数量
     *
     * @param projectId
     * @return  返回没完成的Bug数
     */
    int countBugByProjectNoFinished(String projectId);

    /**
     * 分页查找用户被指派的Bug
     *
     * @param userId
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Bug> findByUserDesignee(String userId, int currentPage, int pageSize);

    /**
     * 更新Bug
     *
     * @param bug
     * @param currentUser
     * @return  返回更新行数
     * @throws SystemException
     */
    int update(Bug bug, User currentUser) throws SystemException;

    /**
     * 删除Bug
     *
     * @param bugId
     * @param currentUser
     * @throws SystemException
     */
    void delete(String bugId, User currentUser) throws SystemException;
}
