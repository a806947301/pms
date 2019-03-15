package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.LoginLog;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.LoginLogService;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IpUtil;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户模块控制器
 *
 * @author WuTong<wut @ pvc123.com>
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

    /**
     * 跳转登陆日志页面
     *
     * @param id
     * @return
     */
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
     * 跳转注册页面
     *
     * @return
     */
    @RequestMapping("/registerPage")
    public String registerPage() {
        return "register";
    }

    /**
     * 获取验证码
     *
     * @param email
     * @return
     * @throws MessagingException
     */
    @RequestMapping("/getVarification")
    @ResponseBody
    public JSONObject getVarification(String email) throws MessagingException {
        //生成验证码
        String varificationCode = userService.doRandomVarificationCodeToEmail(email);
        return JsonUtil.packageJson(true, varificationCode,"");
    }

    /**
     * 分页查找
     *
     * @return
     */
    @RequestMapping("/findUser")
    @ResponseBody
    @RequiresPermissions("select:user")
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
    @RequiresPermissions("add:user")
    public JSONObject addUser(User user) {
        boolean addSuccess = userService.addUser(user) != 0;
        return JsonUtil.packageJson(addSuccess, "添加成功", "添加失败");
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    @RequiresPermissions("update:user")
    public JSONObject updateUser(User user) {
        boolean updateSuccess = (userService.updateUser(user) != 0);
        return JsonUtil.packageJson(updateSuccess,"更新成功","更新失败");
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
        boolean loginSuccess = userService.doLogin(email, password, IpUtil.getIpAddress(request));
        return JsonUtil.packageJson(loginSuccess, INDEX_PAGE, "登陆失败");
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
        return JsonUtil.packageJson(logoutSuccess, "退出登陆", "退出登陆失败！！！");
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
    @RequiresPermissions("delete:user")
    public JSONObject updateStopped(String id, boolean stopped) {
        int countUpdate = userService.updateUserStopped(id, stopped);
        boolean updateSuccess = (0 != countUpdate);
        return JsonUtil.packageJson(updateSuccess, "停用/启用成功", "停用/启用失败");
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
    @RequiresPermissions("loginLog")
    public PageInfo<LoginLog> findLoginLogByUserId(String id, int currentPage) {
        if (null == id) {
            User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
            id = user.getId();
        }
        PageInfo<LoginLog> logs = loginLogService.findLoginLogByUserId(id, currentPage, 10);
        return logs;
    }

    /**
     * 查找指定产品下指定角色的成员
     *
     * @param productId
     * @param roleId
     * @return
     */
    @RequestMapping("/findUserByproductIdRole")
    @ResponseBody
    public List<User> findUserByproductIdRole(String productId, String roleId) {
        return userService.findUserByproductIdRole(productId, roleId);
    }

    /**
     * 查询邮箱是否已被注册
     *
     * @param email
     * @return
     */
    @RequestMapping("/existEmail")
    @ResponseBody
    public JSONObject existEmail(String email) {
        boolean existEmail = userService.doExistEmail(email);
        return JsonUtil.packageJson(true, existEmail, "");
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public JSONObject register(User user) {
        boolean resigterSuccess = (userService.addUser(user) != 0);
        return JsonUtil.packageJson(resigterSuccess,"注册成功","注册失败");
    }
}
