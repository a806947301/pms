package com.dayi.demo.product.service;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.user.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 产品模块Service层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
public interface ProductService {

    /**
     * 添加产品
     *
     * @param product       产品
     * @param participators 参与者
     * @return
     * @throws SystemException
     */
    String add(Product product, String[] participators) throws SystemException;

    /**
     * 分页查询产品
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Product> findByPage(int currentPage, int pageSize);

    /**
     * 根据id获取产品
     *
     * @param id
     * @return
     */
    Product get(String id);

    /**
     * 获取产品参与者
     *
     * @param id
     * @return
     */
    List<User> getParticipator(String id);

    /**
     * 添加产品组成员
     *
     * @param id
     * @param newParticipator
     * @return
     * @throws SystemException
     */
    int addParticipator(String id, String[] newParticipator) throws SystemException;

    /**
     * 删除产品组成员
     *
     * @param productId
     * @param userId
     * @return
     * @throws SystemException
     */
    void deleteParticipator(String productId, String userId) throws SystemException;

    /**
     * 添加产品参与者
     *
     * @param entity
     * @param productId
     * @param participatorId
     * @return
     */
    public int addParticipator(BaseEntity entity, String productId, String participatorId);

    /**
     * 更新产品信息
     *
     * @param product
     * @throws SystemException
     */
    void update(Product product) throws SystemException;

    /**
     * 查找所有产品
     *
     * @return
     */
    List<Product> findAll();

    /**
     * 分页查找用户参与的产品
     *
     * @param userId
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Product> findByUser(String userId, int currentPage, int pageSize);
}
