package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户模块控制器
 * @Author wut
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 跳转用户管理页面
     * @return
     */
    @RequestMapping("/userManager")
    public String userManager() {
        return "userManager";
    }

    /**
     * 分页显示
     * @return
     */
    @RequestMapping("/findUser")
    @ResponseBody
    public PageInfo<User> findUser(int currentPage) {
        return userService.findByPage(currentPage,5);
    }

    /**
     * 查找所有用户
     * @return
     */
    @RequestMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser(User user) {
        return userService.addUser(user);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public int updateUser(User user) {
        return userService.updateUser(user);
    }

    @RequestMapping("/findUserByProductId")
    @ResponseBody
    public List<User> findUserByProductId(String id) {
        return userService.findUserByProductId(id);
    }

}
