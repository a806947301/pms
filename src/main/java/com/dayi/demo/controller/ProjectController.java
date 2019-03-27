package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.util.Result;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Result addProject(Project project) {
        //判断非空
        if (Project.hasEmpty(project, false)) {
            return new Result(false, "字段必须不为空");
        }

        //添加项目
        String projectId = null;
        try {
            projectId = projectService.add(project, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, projectId);
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
    public Result findProject(int currentPage, int pageSize) {
        PageInfo<Project> pageInfo = projectService.findByPage(currentPage, pageSize);
        return new Result(true, "", pageInfo);
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
    public Result findByProductId(String productId, int currentPage, int pageSize) {
        PageInfo<Project> pageInfo = projectService.findByProductIdPage(productId, currentPage, pageSize);
        return new Result(true, "", pageInfo);
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
    public String gerProductPage(@PathVariable("id") String id) {
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
    public Result getProject(String id) {
        Project project = projectService.get(id);
        return new Result(true, "", project);
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
    public Result updateProject(Project project) {
        // 判断非空
        if (Project.hasEmpty(project, true)) {
            return new Result(false, "字段必须不为空");
        }

        // 更新项目
        try {
            projectService.update(project, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "更新项目成功");
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
    public Result updateProjectFinished(Project project) {
        //判断非空
        if (null == project.getId() || "".equals(project.getId())) {
            return new Result(false, "字段必须不为空");
        }

        //更新项目状态
        try {
            projectService.updateProjectFinished(project, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "更新成功");
    }

    /**
     * 删除项目
     *
     * @param projectId
     * @param request
     * @return
     */
    @RequestMapping("/deleteProject")
    @ResponseBody
    @RequiresPermissions("delete:project")
    public Result deleteProject(String projectId, HttpServletRequest request) {
        //判断非空
        if (null == projectId || "".equals(projectId)) {
            return new Result(false, "字段必须不为空");
        }

        //删除项目
        String realPath = request.getSession().getServletContext().getRealPath("/imgs/" + projectId);
        try {
            projectService.delete(projectId, realPath, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "删除项目成功");
    }
}
