package com.dayi.demo.user.service.impl;

import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.dao.UserDao;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.LoginLogService;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.MailUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * 用户模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Resource
    private LoginLogService loginLogService;

    @Override
    public void update(User user) throws SystemException {
        //判断用户是否存在
        User oldUser = get(user.getId());
        if (null == oldUser) {
            throw new SystemException("用户不存在");
        }

        //更新用户
        int countUpdate = userDao.update(user);
        if (0 == countUpdate) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public void add(User user) throws SystemException {
        user.setPassword(encryptMd5(user));
        int countAdd = userDao.add(user);
        if (0 == countAdd) {
            throw new SystemException("操作失败");
        }

        //添加日志
        if (logger.isInfoEnabled()) {
            logger.info("用户注册，注册Email：{}", user.getEmail());
        }
    }

    @Override
    public PageInfo<User> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> list = userDao.findAllIncludeStopped();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }

    @Override
    public List<User> findByProductId(String productId) {
        return userDao.findUserByProductId(productId);
    }

    @Override
    public List<User> findByUserRole(String userId, String roleId) {
        return userDao.findUserByUserRole(userId, roleId);
    }

    @Override
    public User get(String id) {
        return userDao.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public boolean doLogin(String email, String password, String ip) {
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //登陆
        subject.login(new UsernamePasswordToken(email, password));
        //把当前用户存进Session
        Session session = SecurityUtils.getSubject().getSession();
        User currentUser = getByEmail(email);
        session.setAttribute("user", currentUser);

        //添加日志
        if (logger.isInfoEnabled()) {
            logger.info("Email：{} 登陆了系统，登陆IP为：{}", email, ip);
        }
        return true;
    }

    @Override
    public void doLogout() {
        SecurityUtils.getSubject().logout();
    }

    @Override
    public List<User> findByproductIdRole(String productId, String roleId) {
        return userDao.findUserByproductIdRole(productId, roleId);
    }

    @Override
    public String doRandomVerificationCodeToEmail(String email) throws SystemException {
        //随机生成四位数验证码
        Random random = new Random();
        int verificationCode = random.nextInt(9000) + 1000;

        //发送邮件
        String title = "您的验证码";
        String content = "您的验证码为：" + verificationCode;
        try {
            MailUtil.sendMail(email, title, content);
        } catch (Exception e) {
            //添加错误日志
            if (logger.isErrorEnabled()) {
                logger.error(email + "_" + e.getMessage(), e);
            }

            throw new SystemException("邮件发送失败");
        }
        return verificationCode + "";
    }

    @Override
    public boolean doExistEmail(String email) {
        User user = userDao.getByEmail(email);
        return (user != null);
    }

    @Override
    public int countDepartmentId(String departmentId) {
        return userDao.countDepartmentId(departmentId);
    }

    /**
     * 把明文密码进行加密
     *
     * @param user
     * @return
     */
    private String encryptMd5(User user) {
        //获取盐值
        ByteSource source = ByteSource.Util.bytes(user.getId());
        //加密
        String result = new SimpleHash("MD5", user.getPassword(), source, 2).toHex();
        return result;
    }

    @Override
    public boolean isInProduct(String userId, String productId) {
        return userDao.isInProduct(userId, productId);
    }
}
