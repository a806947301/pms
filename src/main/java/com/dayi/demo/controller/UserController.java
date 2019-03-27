package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.LoginLog;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.LoginLogService;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IpUtil;
import com.dayi.demo.util.Result;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
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
     * @param email 验证码发送到的邮箱
     * @return
     */
    @RequestMapping("/getVerification")
    @ResponseBody
    public Result getVerification(String email) {
        //判断邮箱非空
        if (null == email || "".equals(email)) {
            return new Result(false, "邮箱不能为空");
        }
        //生成验证码
        String varificationCode = null;
        try {
            varificationCode = userService.doRandomVerificationCodeToEmail(email);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "", varificationCode);
    }

    /**
     * 分页查找
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findUser")
    @ResponseBody
    @RequiresPermissions("select:user")
    public Result findUser(int currentPage, int pageSize) {
        PageInfo<User> pageInfo = userService.findByPage(currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 查找所有用户
     *
     * @return
     */
    @RequestMapping("/findAllUser")
    @ResponseBody
    public Result findAllUser() {
        List<User> list = userService.findAll();
        return new Result(true, "", list);
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
    public Result addUser(User user) {
        //判断非空
        if (User.hasEmpty(user, false, true)) {
            return new Result(false, "有字段为空");
        }

        //添加用户
        try {
            userService.add(user);
        } catch (SystemException e) {
            new Result(false, e.getMessage());
        }
        return new Result(true, "添加用户成功");
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
    public Result updateUser(User user) {
        //判断非空
        if (null == user || null == user.getId() || "".equals(user.getId())) {
            return new Result(false, "有字段为空");
        }

        //更新用户
        try {
            userService.update(user);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "更新用户成功");
    }

    /**
     * 查找产品组所有成员
     *
     * @param id
     * @return
     */
    @RequestMapping("/findUserByProductId")
    @ResponseBody
    public Result findUserByProductId(String id) {
        List<User> list = userService.findByProductId(id);
        return new Result(true, "", list);
    }

    /**
     * 登陆
     *
     * @param email
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(String email, String password, HttpServletRequest request) {
        //判断非空
        if (null == email || "".equals(email)) {
            return new Result(false, "邮箱不能为空");
        }
        if (null == password || "".equals(password)) {
            return new Result(false, "密码不能为空");
        }

        //登陆
        try {
            userService.doLogin(email, password, IpUtil.getIpAddress(request));
        } catch (AuthenticationException e) {
            return new Result(false, "用户名或密码不正确");
        }
        return new Result(true, INDEX_PAGE);
    }

    /**
     * 退出登陆
     *
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Result logout() {
        //取消session数据
        SecurityUtils.getSubject().getSession().removeAttribute("user");
        //退出登陆
        userService.doLogout();
        return new Result(true, "退出登陆");
    }

    /**
     * 分页获取当前用户的登陆日志
     *
     * @param id
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/loginLogByUser")
    @ResponseBody
    @RequiresPermissions("loginLog")
    public Result findLoginLogByUserId(String id, int currentPage, int pageSize) {
        //如果Id为空，则设置为当前用户id
        if (null == id) {
            User user = getCurrentUser();
            id = user.getId();
        }
        PageInfo<LoginLog> logs = loginLogService.findLoginLogByUserId(id, currentPage, pageSize);
        return new Result(true, "", logs);
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
    public Result findUserByproductIdRole(String productId, String roleId) {
        List<User> list = userService.findByproductIdRole(productId, roleId);
        return new Result(true, "", list);
    }

    /**
     * 查询邮箱是否已被注册
     *
     * @param email
     * @return
     */
    @RequestMapping("/existEmail")
    @ResponseBody
    public Result existEmail(String email) {
        boolean existEmail = userService.doExistEmail(email);
        return new Result(true, "", existEmail);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Result register(User user) {
        //判断非空
        if (User.hasEmpty(user, false, true)) {
            return new Result(false, "有字段为空");
        }

        //注册
        try {
            userService.add(user);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "注册成功");
    }

    /**
     * 当前用户是否参与产品
     *
     * @param productId
     * @return
     */
    @RequestMapping("/isInProduct")
    @ResponseBody
    public Result isInProduct(String productId) {
        boolean inProduct = userService.isInProduct(getCurrentUser().getId(), productId);
        return new Result(true, "", inProduct);
    }
}
