package com.dayi.demo.product.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.product.dao.ProductDao;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductDao productDao;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Override
    public String addProduct(Product product, String[] participators) {
        // 添加产品
        product.setId(IdUtils.getPrimaryKey());
        product.setAddTime(new Date());
        product.setUpdateTime(new Date());
        int countAdd = productDao.addProduct(product);

        //  添加产品成员
        for (String participator : participators) {
            String id = IdUtils.getPrimaryKey();
            Date addTime = new Date();
            Date updateTime = new Date();
            productDao.addProductParticipator(id, product.getId(), participator, addTime, updateTime);
        }
        // 判断产品是否添加成功
        if (countAdd != 0) {
            return product.getId();
        }
        return "";
    }

    @Override
    public PageInfo<Product> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Product> list = productDao.findAllProduct();
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Product getProduct(String id) {
        return productDao.getProduct(id);
    }

    @Override
    public List<User> getParticipator(String id) {
        List<User> paticipator = userService.findUserByProductId(id);
        return paticipator;
    }

    @Override
    public int addParticipator(String id, String[] newParticipator) {
        // 计算被添加的行数
        int countAdd = 0;
        for (String participator : newParticipator) {
            String participatorId = IdUtils.getPrimaryKey();
            Date addTime = new Date();
            Date updateTime = new Date();
            countAdd += productDao.addProductParticipator(participatorId, id, participator, addTime, updateTime);
        }
        return countAdd;
    }

    @Override
    public int deleteParticipator(String productId, String userId) {
        return productDao.deleteParticipator(productId, userId);
    }

    @Override
    public int updateProduct(Product product) {
        product.setUpdateTime(new Date());
        return productDao.updateProduct(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }

}
