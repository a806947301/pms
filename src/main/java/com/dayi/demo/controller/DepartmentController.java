package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.user.model.Department;
import com.dayi.demo.user.service.DepartmentService;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 部门管理控制器
 *
 * @author WuTong<wut   @   pvc123.com>
 * @date 2019-2-20
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Resource
    private DepartmentService departmentService;

    /**
     * 删除部门
     *
     * @param id 部门id
     * @return
     */
    @RequestMapping("/deleteDepartment")
    @ResponseBody
    @RequiresPermissions("delete:department")
    public JSONObject deleteDepartment(String id) {
        if (null == id || "".equals(id)) {
            return JsonUtil.packageJson(false, "", "删除失败，id不能为空");
        }
        try {
            departmentService.delete(id);
        } catch (Exception e) {
            logger.error(DepartmentController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "删除成功", "");
    }

    /**
     * 更新部门
     *
     * @param department
     * @return
     */
    @RequestMapping("/updateDepartment")
    @ResponseBody
    @RequiresPermissions("update:department")
    public JSONObject updateDepartment(Department department) {
        if (Department.hasEmpty(department, true)) {
            return JsonUtil.packageJson(false, "", "有字段为空");
        }
        try {
            departmentService.update(department);
        } catch (Exception e) {
            logger.error(DepartmentController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "更新成功", "");
    }

    /**
     * 添加部门
     *
     * @return
     */
    @RequestMapping("/addDepartment")
    @ResponseBody
    @RequiresPermissions("add:department")
    public JSONObject addDepartment(Department department) {
        if (Department.hasEmpty(department, false)) {
            return JsonUtil.packageJson(false, "", "部门名不能为空");
        }
        try {
            departmentService.add(department);
        } catch (Exception e) {
            logger.error(DepartmentController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "添加成功", "");
    }

    /**
     * 跳转部门管理页面
     *
     * @return
     */
    @RequestMapping("/departmentManegerPage")
    public String departmentManagerPage(HttpServletRequest request) {
        return "departmentManager";
    }

    /**
     * 分页显示部门
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findDepartment")
    @ResponseBody
    @RequiresPermissions("select:department")
    public PageInfo<Department> findByPage(int currentPage, int pageSize) {
        PageInfo<Department> departments = departmentService.findByPage(currentPage, pageSize);
        return departments;
    }

    /**
     * 显示所有部门
     *
     * @return
     */
    @RequestMapping("/finfAllDepartment")
    @ResponseBody
    public List<Department> findAll() {
        return departmentService.findAll();
    }

}
