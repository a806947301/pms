package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.LoginLog;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.LoginLogService;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IpUtils;
import com.dayi.demo.util.JsonUtils;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户模块控制器
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-23
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private LoginLogService loginLogService;

    private static final String INDEX_PAGE = "/user/index";

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    /**
     * 跳转主页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/loginLogPage")
    public String loginLogPage(String id) {
        return "loginLog";
    }


    /**
     * 跳转用户管理页面
     *
     * @return
     */
    @RequestMapping("/userManager")
    public String userManager() {
        return "userManager";
    }

    /**
     * 分页查找
     *
     * @return
     */
    @RequestMapping("/findUser")
    @ResponseBody
    public PageInfo<User> findUser(int currentPage) {
        return userService.findByPage(currentPage, 5);
    }

    /**
     * 查找所有用户
     *
     * @return
     */
    @RequestMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public JSONObject addUser(User user) {

        boolean addSuccess = userService.addUser(user) != 0;
        return JsonUtils.packageJson(addSuccess, "添加成功", "添加失败");
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public int updateUser(User user) {
        return userService.updateUser(user);
    }

    /**
     * 查找产品组所有成员
     *
     * @param id
     * @return
     */
    @RequestMapping("/findUserByProductId")
    @ResponseBody
    public List<User> findUserByProductId(String id) {
        return userService.findUserByProductId(id);
    }

    /**
     * 登陆
     *
     * @param email
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(String email, String password, HttpServletRequest request) {
        boolean loginSuccess = userService.doLogin(email, password, IpUtils.getIpAddress(request));
        return JsonUtils.packageJson(loginSuccess, INDEX_PAGE, "登陆失败");
    }

    /**
     * 退出登陆
     *
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public JSONObject logout() {
        boolean logoutSuccess = userService.doLogout();
        return JsonUtils.packageJson(logoutSuccess, "退出登陆", "退出登陆失败！！！");
    }

    /**
     * 启用/停用用户
     *
     * @param id
     * @param stopped
     * @return
     */
    @RequestMapping("/updateStopped")
    @ResponseBody
    public JSONObject updateStopped(String id, boolean stopped) {
        int countUpdate = userService.updateUserStopped(id, stopped);
        boolean updateSuccess = (0 != countUpdate);
        return JsonUtils.packageJson(updateSuccess, "停用/启用成功", "停用/启用失败");
    }

    /**
     * 获取用户的登陆日志
     *
     * @param id
     * @param currentPage
     * @return
     */
    @RequestMapping("/loginLogByUser")
    @ResponseBody
    public PageInfo<LoginLog> findLoginLogByUserId(String id, int currentPage) {
        if (null == id) {
            User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
            id = user.getId();
        }
        PageInfo<LoginLog> logs = loginLogService.findLoginLogByUserId(id, currentPage, 10);
        return logs;
    }


}
