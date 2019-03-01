package com.dayi.demo.product.service;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.user.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author wut
 */
public interface ProductService {
    /**
     * 添加产品
     * @param product   产品
     * @param participators 参与者
     * @return
     */
    String addProduct(Product product,String[] participators);

    /**
     * 分页查询产品
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Product> findByPage(int currentPage,int pageSize);

    /**
     * 根据id获取产品
     * @param id
     * @return
     */
    Product getProduct(String id);

    /**
     * 获取产品参与者
     * @param id
     * @return
     */
    public List<User> getParticipator(String id);

    /**
     * 添加产品组成员
     * @param id
     * @param newParticipator
     * @return
     */
    public int addParticipator(String id,String[] newParticipator);

    /**
     * 删除产品组成员
     * @param productId
     * @param userId
     * @return
     */
    public int deleteParticipator(String productId,String userId);

    /**
     * 更新产品信息
     * @param product
     * @return
     */
    public int updateProduct(Product product);

    /**
     * 查找所有产品
     * @return
     */
    public List<Product> findAllProduct();
}
