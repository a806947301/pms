package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.Department;
import com.dayi.demo.user.service.DepartmentService;
import com.dayi.demo.util.JsonUtil;
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
public class DepartmentController {

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
        int countDelete = departmentService.deleteDepartment(id);
        boolean deleteSuccess = (0 != countDelete);
        return JsonUtil.packageJson(deleteSuccess,"删除成功","删除失败");
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
        int countUpdate = departmentService.updateDepartment(department);
        boolean updateSuccess = (0 != countUpdate);
        return JsonUtil.packageJson(updateSuccess,"更新成功","更新失败");
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
        int countAdd = departmentService.addDepartment(department);
        boolean addSuccess = (0 != countAdd);
        return null;
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

    @RequestMapping("/test")
    @ResponseBody
    public String test() throws Exception{
        Department d = new Department();

        departmentService.addDepartment(d);

        return "";
    }


}
