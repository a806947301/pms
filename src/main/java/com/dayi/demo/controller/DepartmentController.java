package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.Department;
import com.dayi.demo.user.service.DepartmentService;
import com.dayi.demo.util.Result;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 部门管理控制器
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-20
 */
@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {

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
    public Result deleteDepartment(String id) {
        //判断非空
        if (null == id || "".equals(id)) {
            return new Result(false, "删除失败，id不能为空");
        }

        //删除部门
        try {
            departmentService.delete(id);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "删除成功");
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
    public Result updateDepartment(Department department) {
        //判断非空
        if (Department.hasEmpty(department, true)) {
            return new Result(false, "字段不能为空");
        }

        //更新部门
        try {
            departmentService.update(department);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "更新成功");
    }

    /**
     * 添加部门
     *
     * @return
     */
    @RequestMapping("/addDepartment")
    @ResponseBody
    @RequiresPermissions("add:department")
    public Result addDepartment(Department department) {
        //判断非空
        if (Department.hasEmpty(department, false)) {
            return new Result(false, "部门名不能为空");
        }

        //添加部门
        try {
            departmentService.add(department);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "添加成功");
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
    public Result findByPage(int currentPage, int pageSize) {
        PageInfo<Department> pageInfo = departmentService.findByPage(currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 显示所有部门
     *
     * @return
     */
    @RequestMapping("/finfAllDepartment")
    @ResponseBody
    public Result findAll() {
        List<Department> list = departmentService.findAll();
        return new Result(true, "", list);
    }

}
