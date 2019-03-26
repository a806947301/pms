package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.LoginLog;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.LoginLogService;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IpUtil;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
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
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-23
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

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
        //判断邮箱非空
        if (null == email || "".equals(email)) {
            return JsonUtil.packageJson(false, "", "邮箱不能为空");
        }
        //生成验证码
        String varificationCode = null;
        try {
            varificationCode = userService.doRandomVarificationCodeToEmail(email);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, varificationCode, "");
    }

    /**
     * 分页查找
     *
     * @return
     */
    @RequestMapping("/findUser")
    @ResponseBody
    @RequiresPermissions("select:user")
    public PageInfo<User> findUser(int currentPage, int pageSize) {
        return userService.findByPage(currentPage, pageSize);
    }

    /**
     * 查找所有用户
     *
     * @return
     */
    @RequestMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser() {
        return userService.findAll();
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
        //判断非空
        if (User.hasEmpty(user, false, true)) {
            return JsonUtil.packageJson(false, "", "有字段为空！");
        }

        //添加用户
        try {
            userService.add(user);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "添加用户成功", "");
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
        //判断非空
        if (null == user || null == user.getId() || "".equals(user.getId())) {
            return JsonUtil.packageJson(false, "", "有字段为空！");
        }

        //更新用户
        try {
            userService.update(user);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "更新用户成功", "");
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
        return userService.findByProductId(id);
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
        //判断非空
        if (null == email || "".equals(email)) {
            return JsonUtil.packageJson(false, "", "邮箱不能为空");
        }
        if (null == password || "".equals(password)) {
            return JsonUtil.packageJson(false, "", "密码不能为空");
        }

        //登陆
        try {
            userService.doLogin(email, password, IpUtil.getIpAddress(request));
        } catch (AuthenticationException e) {
            return JsonUtil.packageJson(false, "", "用户名或密码不正确");
        }
        return JsonUtil.packageJson(true, INDEX_PAGE, "");
    }

    /**
     * 退出登陆
     *
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public JSONObject logout() {
        //取消session数据
        SecurityUtils.getSubject().getSession().removeAttribute("user");
        //退出登陆
        userService.doLogout();
        return JsonUtil.packageJson(true, "退出登陆", "");
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
    public PageInfo<LoginLog> findLoginLogByUserId(String id, int currentPage, int pageSize) {
        //如果Id为空，则设置为当前用户id
        if (null == id) {
            User user = getCurrentUser();
            id = user.getId();
        }
        PageInfo<LoginLog> logs = loginLogService.findLoginLogByUserId(id, currentPage, pageSize);
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
        return userService.findByproductIdRole(productId, roleId);
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
        //判断非空
        if (User.hasEmpty(user, false, true)) {
            return JsonUtil.packageJson(false, "", "有字段为空！");
        }

        //注册
        try {
            userService.add(user);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "注册成功", "");
    }
}
