package com.dayi.demo.bug.service.impl;

import com.dayi.demo.bug.dao.BugDao;
import com.dayi.demo.bug.dao.BugDescriptionDao;
import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.bug.service.BugOperatingRecordService;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.bug.strategy.BugStatusStrategy;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.statistic.model.vo.ProjectBugVo;
import com.dayi.demo.statistic.model.vo.UserBugVo;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.MailUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * Bug模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BugServiceImpl implements BugService {

    private final static Logger logger = LoggerFactory.getLogger(BugServiceImpl.class);

    @Resource
    private BugDao bugDao;

    @Resource
    private BugDescriptionDao bugDescriptionDao;

    @Resource
    private BugOperatingRecordService recordService;

    @Resource
    private List<BugStatusStrategy> bugStatusStrategies;

    @Resource
    private UserService userService;

    @Override
    public String add(Bug bug, User currentUser) throws SystemException {
        //判断当前用户是否参与此产品
        String productId = bug.getProject().getProduct().getId();
        String userId = currentUser.getId();
        if (!userService.isInProduct(userId, productId)) {
            throw new SystemException("您没参与此产品");
        }

        //设置Bug
        bug.setBugStatus(Bug.Status.DESIGNATE.getValue());
        bug.setNoProcessing(false);
        bug.setBugProposer(currentUser);

        //添加Bug
        int countAdd = bugDao.add(bug);
        //如果添加成功
        if (countAdd != 0) {
            //添加日志
            if (logger.isInfoEnabled()) {
                logger.info("添加Bug，Bug Id：{}", bug.getId());
            }

            // 更新Bug状态
            BugService currentProxy = (BugService)AopContext.currentProxy();
            currentProxy.updateStatus(bug, currentUser);
            return bug.getId();
        }
        throw new SystemException("添加失败");
    }

    @Override
    public Map<String, String> doBugImgUpload(MultipartFile file, String projectId, String realPath) {
        Map<String, String> result = new HashMap<String, String>(16);
        // 获取文件上传目录，如不存在，创建新目录
        File imgFilePath = new File(realPath + "\\imgs\\" + projectId);
        if (!imgFilePath.exists()) {
            imgFilePath.mkdirs();
        }
        //重命名文件名
        String filename = UUID.randomUUID().toString() + file.getOriginalFilename();
        File imgFile = null;
        try {
            //保存图片
            imgFile = new File(imgFilePath, filename);
            file.transferTo(imgFile);
            result.put("success", "true");
            // 拼接图片src
           String imgSrc = "/imgs/" + projectId + "/" + filename;
            result.put("file_path", imgSrc);
        } catch (Exception e) {
            //添加错误日志
            if (logger.isErrorEnabled()) {
                logger.error(imgFile + "_" + e.getMessage(), e);
            }
            result.put("success", "false");
        }
        return result;
    }

    @Override
    public PageInfo<Bug> findByProject(int currentPage, int pageSize, String projectId, Date begin, Date end,
                                       int status, String processerId, String proposerId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Bug> list = bugDao.findByProject(projectId, begin, end, status, processerId, proposerId);
        PageInfo<Bug> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Bug get(String id) {
        return bugDao.get(id);
    }

    @Override
    public Bug updateStatus(Bug bug, User currentUser) throws SystemException {
        //判断非空
        Integer status = bug.getBugStatus();
        if (null == status) {
            throw new SystemException("状态为空");
        }

        //获取状态对应策略
        BugStatusStrategy strategy = bugStatusStrategies.get(status);
        //判断策略是否存在
        if(null == strategy) {
            throw new SystemException("更新失败，没有该策略");
        }

        //添加Debug日志
        if (logger.isDebugEnabled()) {
            logger.debug("更新Bug状态，获取到更新策略：{}", strategy.getClass().getName());
        }
        //获取更新的Bug
        Bug oldBug = get(bug.getId());
        Bug updateBug = strategy.update(bug, oldBug, currentUser);

        //如果获取到为空
        if (null == updateBug) {
            throw new SystemException("更新失败");
        }
        int countUpdate = update(updateBug, null);
        if (0 == countUpdate) {
            throw new SystemException("更新失败");
        }
        return get(bug.getId());
    }

    @Override
    public void addBugDescription(BugDescription bugDescription, User currentUser) throws SystemException {
        //拼接Bug表要更新字段
        Bug bug = new Bug();
        //设置Bug id 为添加说明的Bugid
        bug.setId(bugDescription.getBugId());
        //设置Bug状态为验收
        bug.setBugStatus(Bug.Status.CHECKING.getValue());

        //更新Bug状态
        BugService currentProxy = (BugService) AopContext.currentProxy();
        currentProxy.updateStatus(bug, currentUser);

        // 添加Bug说明
        int countAdd = bugDescriptionDao.add(bugDescription);
        if (countAdd == 0) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public int update(Bug bug, User currentUser) throws SystemException {
        if (null != currentUser) {
            //判断是否本人
            Bug oldBug = get(bug.getId());
            boolean isProposer = currentUser.getId().equals(oldBug.getBugProposer().getId());
            if (!isProposer) {
                throw new SystemException("您不是Bug提出者本人");
            }

            //更新Bug
            return bugDao.update(bug);
        } else {
            bug.setUpdateTime(new Date());
            return bugDao.update(bug);
        }
    }

    @Override
    public PageInfo<BugDescription> findDescriptionByBugId(String bugId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<BugDescription> list = bugDescriptionDao.findByBugId(bugId);
        PageInfo<BugDescription> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @Override
    public Map<String, ProjectBugVo> countBugByProject() {
        HashMap<String, ProjectBugVo> result = new LinkedHashMap<String, ProjectBugVo>(32);
        // 把项目Vo List 封装成 <项目Id：项目 Vo>对应的HashMap
        List<ProjectBugVo> list = bugDao.countBugByProject();
        for (ProjectBugVo vo : list) {
            result.put(vo.getProjectId(), vo);
        }
        return result;
    }

    @Override
    public Map<String, UserBugVo> countBugByProcesser() {
        HashMap<String, UserBugVo> result = new LinkedHashMap<String, UserBugVo>(32);
        // 把用户Vo List 封装成 <用户Id：用户Bug Vo>对应的HashMap
        List<UserBugVo> userBugVos = bugDao.countBugByProcesser();
        for (UserBugVo user : userBugVos) {
            result.put(user.getUserId(), user);
        }
        return result;
    }

    @Override
    public Map<String, UserBugVo> countBugByProposer() {
        HashMap<String, UserBugVo> result = new LinkedHashMap<String, UserBugVo>(32);
        // 把用户Vo List 封装成 <用户Id：用户Bug Vo>对应的HashMap
        List<UserBugVo> userBugVos = bugDao.countBugByProposer();
        for (UserBugVo user : userBugVos) {
            result.put(user.getUserId(), user);
        }
        return result;
    }

    @Override
    public int countBugByProjectNoFinished(String projectId) {
        return bugDao.countBugByProjectNoFinished(projectId);
    }

    @Override
    public PageInfo<Bug> findByUserDesignee(String userId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Bug> list = bugDao.findByUserDesignee(userId);
        PageInfo<Bug> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void delete(String bugId, User currentUser) throws SystemException {
        //判断是否存在
        Bug bug = get(bugId);
        if (null == bug) {
            throw new SystemException("不存在Bug");
        }

        //判断是否本人
        boolean isProposer = currentUser.getId().equals(bug.getBugProposer().getId());
        if (!isProposer) {
            throw new SystemException("您不是Bug提出者");
        }

        //删除Bug说明
        bugDescriptionDao.deleteByBugId(bugId);
        //删除Bug记录
        recordService.deleteByBugId(bugId);
        //删除Bug
        int countDelete = bugDao.delete(bugId);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }

        //添加日志
        if (logger.isInfoEnabled()) {
            logger.info("删除Bug，Bug ID：{}", bugId);
        }
    }

}
