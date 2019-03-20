package com.dayi.demo.project.service.impl;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.need.model.Need;
import com.dayi.demo.need.service.NeedService;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.project.dao.ProjectDao;
import com.dayi.demo.project.model.Project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Resource
    private ProjectDao projectDao;

    @Autowired
    private BugService bugService;

    @Autowired
    private NeedService needService;

    @Override
    public String add(Project project) throws SystemException {
        project.setFinished(false);
        int countAdd = projectDao.add(project);
        if (countAdd != 0) {
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
    public void update(Project project) throws SystemException {
        //判断是否存在产品
        Project oldProject = get(project.getId());
        if (null == oldProject) {
            throw new SystemException("无此产品");
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
    public void updateProjectFinished(String projectId, boolean finished) throws SystemException {
        //判断是否存在产品
        Project oldProject = get(projectId);
        if (null == oldProject) {
            throw new SystemException("无此产品");
        }
        //是否有Bug没完成
        if (0 != bugService.countBugByProjectNoFinished(projectId)) {
            throw new SystemException("项目还有Bug未完成");
        }
        //更新
        int countUpdate = projectDao.updateIsFinished(projectId, finished);
        if (0 == countUpdate) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public void delete(String id) throws SystemException {
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
    }
}
