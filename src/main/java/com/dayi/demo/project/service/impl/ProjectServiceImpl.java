package com.dayi.demo.project.service.impl;

import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.project.dao.ProjectDao;
import com.dayi.demo.project.model.Project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-2-26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectDao projectDao;

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
        project.setUpdateTime(new Date());
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
    public int updateProjectFinished(String projectId, boolean finished,
                                      int countBugNotfinished) throws SystemException{
        //判断是否存在产品
        Project oldProject = get(projectId);
        if (null == oldProject) {
            throw new SystemException("无此产品");
        }
        //是否有Bug没完成
        if (0 != countBugNotfinished) {
            return 0;
        }
        //更新
        int countUpdate = projectDao.updateIsFinished(projectId, finished);
        if(0 == countUpdate) {
            throw new SystemException("操作失败");
        }
        return  countUpdate;
    }
}
