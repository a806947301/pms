package com.dayi.demo.user.service.impl;

import com.dayi.demo.user.dao.LoginLogDao;
import com.dayi.demo.user.model.LoginLog;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.LoginLogService;
import com.dayi.demo.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-08
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogDao loginLogDao;

    @Override
    public int add(LoginLog loginLog) {
        return loginLogDao.add(loginLog);
    }

    @Override
    public PageInfo<LoginLog> findLoginLogByUserId(String userId,int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<LoginLog> list = loginLogDao.findLoginLogByUserId(userId);
        PageInfo<LoginLog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
