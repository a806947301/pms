package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.dao.UserDao;
import com.dayi.demo.user.model.Department;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.LoginLogService;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private LoginLogService loginLogService;

    @Override
    public int updateUser(User user) {
        User oldUser = getUser(user.getId());
        user.setUpdateTime(new Date());
        user.setStopped(oldUser.isStopped());
        return userDao.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        user.setAddTime(new Date());
        user.setUpdateTime(new Date());
        user.setId(IdUtils.getPrimaryKey());
        user.setPassword(encryptMd5(user));
        return userDao.addUser(user);
    }

    @Override
    public PageInfo<User> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> list = userDao.findAllIncludeStopped();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<User> findAllUser() {
        List<User> list = userDao.findAll();
        return list;
    }

    @Override
    public List<User> findUserByProductId(String productId) {
        return userDao.findUserByProductId(productId);
    }

    @Override
    public List<User> findUserByUserRole(String userId, String roleId) {
        return userDao.findUserByUserRole(userId,roleId);
    }

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public boolean doLogin(String email, String password,String ip) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(email,password));
        }catch (AuthenticationException e) {
            return false;
        }catch (Exception e) {
            return false;
        }
        Session session = SecurityUtils.getSubject().getSession();
        User currentUser = getUserByEmail(email);
        session.setAttribute("user",currentUser);
        loginLogService.addLoginLog(currentUser.getId(),ip);
        return true;
    }

    private String encryptMd5(User user) {
        ByteSource source = ByteSource.Util.bytes(user.getId());
        String result = new SimpleHash("MD5",user.getPassword(),source,2).toHex();
        return result;
    }

    @Override
    public int updateUserStopped(String id,boolean stopped) {
        User oldUser = getUser(id);
        oldUser.setStopped(stopped);
        return userDao.updateUser(oldUser);
    }

    @Override
    public boolean doLogout() {
        SecurityUtils.getSubject().getSession().removeAttribute("user");
        SecurityUtils.getSubject().logout();
        return true;
    }

    @Override
    public List<User> findUserByproductIdRole(String productId, String roleId) {
        return userDao.findUserByproductIdRole(productId,roleId);
    }
}
