package com.dayi.demo.project.service.impl;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.need.model.Need;
import com.dayi.demo.need.service.NeedService;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.project.dao.ProjectDao;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * 项目模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    private final static Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Resource
    private ProjectDao projectDao;

    @Resource
    private BugService bugService;

    @Resource
    private NeedService needService;

    @Resource
    private UserService userService;

    @Override
    public String add(Project project, User currentUser) throws SystemException {
        //判断当前用户是否参与产品
        String userId = currentUser.getId();
        String productId = project.getProduct().getId();
        if (!userService.isInProduct(userId, productId)) {
            throw new SystemException("当前用户没有参与此产品");
        }

        //设置为未完成
        project.setFinished(false);
        //添加项目
        int countAdd = projectDao.add(project);
        if (countAdd != 0) {
            //添加日志
            if (logger.isInfoEnabled()) {
                logger.info("添加项目，项目Id:{}", project.getId());
            }

            return project.getId();
        }
        throw new SystemException("操作失败");
    }

    @Override
    public PageInfo<Project> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Project> list = projectDao.findAll();
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Project get(String id) {
        return projectDao.get(id);
    }

    @Override
    public void update(Project project, User currentUser) throws SystemException {
        //获取老项目
        Project oldProject = get(project.getId());

        //判断用户是否参与产品
        String productId = oldProject.getProduct().getId();
        String userId = currentUser.getId();
        if (!userService.isInProduct(userId, productId)) {
            throw new SystemException("当前用户没有参与此产品");
        }
        //判断是否存在项目
        if (null == oldProject) {
            throw new SystemException("无此项目");
        }

        //更新产品
        int countUpdate = projectDao.update(project);
        if (0 == countUpdate) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public PageInfo<Project> findByProductIdPage(String productId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Project> list = projectDao.findByProductId(productId);
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    public void updateProjectFinished(Project project, User currentUser) throws SystemException {
        //是否有Bug没完成
        if (0 != bugService.countBugByProjectNoFinished(project.getId())) {
            throw new SystemException("项目还有Bug未完成");
        }
        //更新
        update(project, currentUser);

    }

    @Override
    public void delete(String id, String realPath, User currentUser) throws SystemException {
        //获取老项目
        Project oldProject = get(id);

        //判断当前用户是否参与产品
        String productId = oldProject.getProduct().getId();
        String userId = currentUser.getId();
        if (!userService.isInProduct(userId, productId)) {
            throw new SystemException("您没有参与此产品");
        }

        //判断项目是否有Bug
        PageInfo<Bug> bugs = bugService.findByProject(1, 1, id, null,
                null, -1, null, null);
        if (0 != bugs.getSize()) {
            throw new SystemException("该项目还有Bug");
        }

        //判断项目是否有需求
        PageInfo<Need> needs = needService.findByProjectId(id, 1, 1);
        if (0 != needs.getSize()) {
            throw new SystemException("该项目还有需求");
        }

        //删除项目
        int countDelete = projectDao.delete(id);
        if (0 == countDelete) {
            throw new SystemException("删除失败");
        }

        //删除项目文件
        FileUtils.deleteQuietly(new File(realPath));

        //添加日志
        if (logger.isInfoEnabled()) {
            logger.info("删除项目，项目Id：{}", id);
        }
    }
}
