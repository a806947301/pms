package com.dayi.demo.common.aspect;

import com.dayi.demo.user.model.LoginLog;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.LoginLogService;
import com.dayi.demo.user.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登陆切面
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-18
 */
@Aspect
@Component
public class LoginAspect {

    @Resource
    private LoginLogService loginLogService;

    @Resource
    private UserService userService;

    /**
     * 登陆切入点
     */
    @Pointcut("execution(* com.dayi.demo.user.service.impl.UserServiceImpl.doLogin(..))")
    public void loginPointCut() { }

    /**
     * 登陆方法执行后，保存登陆日志
     *
     * @param point
     */
    @AfterReturning("loginPointCut()")
    public void afterLogin(JoinPoint point) {
        //获取邮箱
        String email = (String) point.getArgs()[0];
        String ip = (String) point.getArgs()[2];
        User user = userService.getByEmail(email);
        LoginLog loginLog = new LoginLog();
        loginLog.setUser(user);
        loginLog.setIp(ip);
        loginLogService.add(loginLog);
    }
}
