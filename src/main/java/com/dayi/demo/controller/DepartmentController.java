package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.Utils.IdUtil;
import com.dayi.demo.common.department.dao.DepartmentDao;
import com.dayi.demo.common.department.model.Department;
import com.dayi.demo.common.department.service.DepartmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
     * 添加部门
     * @return
     */
    @RequestMapping("/addDepartment")
    public String addDepartment() {
        Department department = new Department();
        department.setAddTime(new Date());
        department.setUpdateTime(new Date());
        department.setDepartmentName("部门1");
        department.setId(IdUtil.getPrimaryKey());
        departmentService.addDepartment(department);
        return "index";
    }

    /**
     * 跳转部门管理页面
     * @return
     */
    @RequestMapping("/departmentManeger")
    public String departmentManagerPage(HttpServletRequest request) {
        return "departmentManager";
    }

    /**
     * 分页显示
     * @return
     */
    @RequestMapping("/departmentPage")
    @ResponseBody
    public String findByPage(HttpServletRequest request) {

        PageInfo<Department> pageInfo = departmentService.findByPage(1,3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageInfo",pageInfo);
        return jsonObject.toString();
    }


}
