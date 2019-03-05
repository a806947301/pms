package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.dao.UserDao;
import com.dayi.demo.user.model.Department;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author wut
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public int updateUser(User user) {

        user.setUpdateTime(new Date());
        return userDao.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        user.setAddTime(new Date());
        user.setUpdateTime(new Date());
        user.setId(IdUtils.getPrimaryKey());
        return userDao.addUser(user);
    }

    @Override
    public PageInfo<User> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> list = userDao.findAll();
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
    public User getUser(String id) {
        return userDao.getUser(id);
    }
}
