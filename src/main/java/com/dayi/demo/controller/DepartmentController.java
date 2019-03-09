package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.Department;
import com.dayi.demo.user.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 部门管理控制器
 * @Author wut
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 删除部门
     * @param id 部门id
     * @return
     */
    @RequestMapping("/deleteDepartment")
    @ResponseBody
    public String deleteDepartment(String id) {
        return departmentService.deleteDepartment(id)+"";
    }

    /**
     * 更新部门
     * @param department
     * @return
     */
    @RequestMapping("/updateDepartment")
    @ResponseBody
    public int updateDepartment(Department department) {
        return  departmentService.updateDepartment(department);
    }

    /**
     * 添加部门
     * @return
     */
    @RequestMapping("/addDepartment")
    @ResponseBody
    public int addDepartment(Department department) {
        System.out.println(department.getDepartmentName());
        return departmentService.addDepartment(department);

    }

    /**
     * 跳转部门管理页面
     * @return
     */
    @RequestMapping("/departmentManegerPage")
    public String departmentManagerPage(HttpServletRequest request) {
        return "departmentManager";
    }

    /**
     * 分页显示
     * @return
     */
    @RequestMapping("/findDepartment")
    @ResponseBody
    public String findByPage(int currentPage) {

        JSONObject jsonObject = departmentService.findByPage(currentPage,3);
        return jsonObject.toString();
    }

    /**
     * 显示所有部门
     * @return
     */
    @RequestMapping("/finfAllDepartment")
    @ResponseBody
    public String findAll() {
        JSONObject jsonObject = departmentService.findAll();
        return jsonObject.toString();
    }


}
