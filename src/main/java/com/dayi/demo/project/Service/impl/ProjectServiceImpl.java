package com.dayi.demo.project.Service.impl;

import com.dayi.demo.project.Service.ProjectService;
import com.dayi.demo.project.dao.ProjectDao;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author wut
 */
@Service
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
        if(countAdd != 0) {
            return project.getId();
        }
        return "";
    }

    @Override
    public PageInfo<Project> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Project> list = projectDao.findAllProduct();
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
}
