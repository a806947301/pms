package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-26
 */
@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController {

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
    @RequiresPermissions("add:project")
    public JSONObject addProject(Project project) {
        String projectId = projectService.addProject(project);
        boolean addSuccess = (null != projectId && (!"".equals(projectId)));
        return JsonUtil.packageJson(addSuccess,projectId,"添加失败");
    }

    /**
     * 分页查找项目
     *
     * @param currentPage
     * @return
     */
    @RequestMapping("/findProject")
    @ResponseBody
    @RequiresPermissions("select:project")
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
    @RequiresPermissions("select:project")
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
    @RequiresPermissions("select:project")
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
    @RequiresPermissions("update:project")
    public JSONObject updateProject(Project project) {
        boolean updateSuccess = (0 != projectService.updateProject(project));
        return JsonUtil.packageJson(updateSuccess,"更新成功","更新失败");
    }

    /**
     * 设置项目完成状态
     *
     * @param projectId
     * @param finished
     * @param countBugNotfinished
     * @return
     */
    @RequestMapping("/updateProjectFinished")
    @ResponseBody
    @RequiresPermissions("update:project")
    public JSONObject updateProjectFinished(String projectId, boolean finished, int countBugNotfinished) {
        int countUpdate = projectService.updateProjectFinished(projectId,finished,countBugNotfinished);
        boolean updateSuccess = 0 != countUpdate;
        return JsonUtil.packageJson(updateSuccess,"更新成功","改项目还有Bug未完成");
    }
}
