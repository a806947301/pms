package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 项目模块控制器
 *
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
        //判断非空
        if (Project.hasEmpty(project, false)) {
            return JsonUtil.packageJson(false, "", "字段必须不为空");
        }

        //添加项目
        String projectId = null;
        try {
            projectId = projectService.add(project);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, projectId, "");
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
    public PageInfo<Project> findProject(int currentPage, int pageSize) {
        return projectService.findByPage(currentPage, pageSize);
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
        return projectService.get(id);
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
        // 判断非空
        if (Project.hasEmpty(project, true)) {
            return JsonUtil.packageJson(false, "", "字段必须非空");
        }

        // 更新项目
        try {
            projectService.update(project);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "更新项目成功", "");
    }

    /**
     * 设置项目完成状态
     *
     * @param project
     * @return
     */
    @RequestMapping("/updateProjectFinished")
    @ResponseBody
    @RequiresPermissions("update:project")
    public JSONObject updateProjectFinished(Project project) {
        //判断非空
        if (null == project.getId() || "".equals(project.getId())) {
            return JsonUtil.packageJson(false, "", "字段必须非空");
        }

        //更新项目状态
        try {
            projectService.updateProjectFinished(project);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "更新成功", "");
    }

    @RequestMapping("/deleteProject")
    @ResponseBody
    @RequiresPermissions("delete:project")
    public JSONObject deleteProject(String projectId, HttpServletRequest request) {
        //判断非空
        if (null == projectId || "".equals(projectId)) {
            return JsonUtil.packageJson(false, "", "字段必须非空");
        }

        //删除项目
        String realPath = request.getSession().getServletContext().getRealPath("/imgs/" + projectId);
        try {
            projectService.delete(projectId, realPath);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "删除项目成功", "");
    }
}
