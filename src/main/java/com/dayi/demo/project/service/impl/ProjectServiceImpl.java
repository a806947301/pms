package com.dayi.demo.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.project.dao.ProjectDao;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectDao projectDao;

    @Override
    public String addProject(Project project) {
        project.setId(IdUtils.getPrimaryKey());
        project.setAddTime(new Date());
        project.setUpdateTime(new Date());
        project.setFinished(false);
        int countAdd = projectDao.addProject(project);
        if (countAdd != 0) {
            return project.getId();
        }
        return "";
    }

    @Override
    public PageInfo<Project> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Project> list = projectDao.findAllProject();
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Project getProject(String id) {
        return projectDao.getProject(id);
    }

    @Override
    public int updateProject(Project project) {
        project.setUpdateTime(new Date());
        return projectDao.updateProject(project);
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
        return projectDao.findAllProject();
    }

    @Override
    public int updateProjectFinished(String projectId, boolean finished, int countBugNotfinished) {
        if(0 != countBugNotfinished) {
            return 0;
        }
        return projectDao.updateIsFinished(projectId,finished);
    }
}
