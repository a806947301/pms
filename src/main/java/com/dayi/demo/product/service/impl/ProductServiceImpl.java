package com.dayi.demo.product.service.impl;

import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.product.dao.ProductDao;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 产品模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductDao productDao;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Override
    public String add(Product product, String[] participators) throws SystemException{
        // 添加产品
        int countAdd = productDao.add(product);

        //  添加产品成员
        for (String participator : participators) {
            String id = IdUtil.getPrimaryKey();
            Date addTime = new Date();
            Date updateTime = new Date();
            productDao.addParticipator(id, product.getId(), participator, addTime, updateTime);
        }
        // 判断产品是否添加成功
        if (countAdd != 0) {
            return product.getId();
        }
        throw new SystemException("操作失败");
    }

    @Override
    public PageInfo<Product> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Product> list = productDao.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Product get(String id) {
        return productDao.get(id);
    }

    @Override
    public List<User> getParticipator(String id) {
        List<User> paticipator = userService.findByProductId(id);
        return paticipator;
    }

    @Override
    public int addParticipator(String id, String[] newParticipator) throws SystemException{
        //判断是否存在产品
        Product product = get(id);
        if(null == product) {
            throw new SystemException("没有该产品");
        }
        // 添加产品成员
        int countAdd = 0;
        for (String participator : newParticipator) {
            String participatorId = IdUtil.getPrimaryKey();
            Date addTime = new Date();
            Date updateTime = new Date();
            countAdd += productDao.addParticipator(participatorId, id, participator, addTime, updateTime);
        }
        return countAdd;
    }

    @Override
    public int deleteParticipator(String productId, String userId) throws SystemException{
        return productDao.deleteParticipator(productId, userId);
    }

    @Override
    public void update(Product product) throws SystemException{
        Product oldProduct = get(product.getId());
        if(null == oldProduct) {
            throw new SystemException("不存在该产品");
        }
        product.setUpdateTime(new Date());
        int countUpdate = productDao.update(product);
        if(0 == countUpdate) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public PageInfo<Product> findByUser(String userId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Product> list = productDao.findByUser(userId);
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
