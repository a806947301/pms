package com.dayi.demo.controller;

import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.project.model.Project;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author wut
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    /**
     * 跳转添加项目页面
     *
     * @return
     */
    @RequestMapping("/addProjectPage")
    public String addProjectPage() {
        return "addProject";
    }

    /**
     * 添加项目
     *
     * @param project
     * @return
     */
    @RequestMapping("/addProject")
    @ResponseBody
    public String addProject(Project project) {
        return projectService.addProject(project);
    }

    /**
     * 分页查找项目
     *
     * @param currentPage
     * @return
     */
    @RequestMapping("/findProject")
    @ResponseBody
    public PageInfo<Project> findProject(int currentPage) {
        return projectService.findByPage(currentPage, 5);
    }

    /**
     * 分页查找产品下的项目
     *
     * @param productId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findByProductId")
    @ResponseBody
    public PageInfo<Project> findByProductId(String productId, int currentPage, int pageSize) {
        return projectService.findByProductIdPage(productId, currentPage, pageSize);
    }

    /**
     * 跳转项目列表页面
     *
     * @return
     */
    @RequestMapping("/findProjectPage")
    public String productList() {
        return "projectList";
    }

    /**
     * 跳转到产品页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getProjectPage/{id}")
    public String gerProductPage(String id) {
        return "getProject";
    }

    /**
     * 获取指定项目信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/getProject")
    @ResponseBody
    public Project getProject(String id) {
        return projectService.getProject(id);
    }

    /**
     * 更新项目信息
     *
     * @param project
     * @return
     */
    @RequestMapping("/updateProject")
    @ResponseBody
    public int updateProject(Project project) {
        return projectService.updateProject(project);
    }
}
