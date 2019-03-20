package com.dayi.demo.product.dao;

import com.dayi.demo.product.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 产品dao层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
public interface ProductDao {

    /**
     * 添加产品
     *
     * @param product
     * @return
     */
    int add(Product product);

    /**
     * 添加产品成员
     *
     * @param id         产品成员表Id，从IdUtil获取
     * @param productId  产品Id
     * @param userId     用户Id
     * @param addTime    添加时间
     * @param updateTime 更新时间
     * @return
     */
    int addParticipator(@Param("id") String id,
                               @Param("productId") String productId,
                               @Param("userId") String userId,
                               @Param("addTime") Date addTime,
                               @Param("updateTime") Date updateTime);

    /**
     * 查找所有产品
     *
     * @return
     */
    List<Product> findAll();

    /**
     * 获取指定产品
     *
     * @param id
     * @return
     */
    Product get(String id);

    /**
     * 删除产品成员
     *
     * @param productId 产品Id
     * @param userId    用户Id
     * @return
     */
    int deleteParticipator(@Param("productId") String productId, @Param("userId") String userId);

    /**
     * 更新产品
     *
     * @param product
     * @return
     */
    int update(Product product);

    /**
     * 查找用户参与的产品
     *
     * @param userId
     * @return
     */
    List<Product> findByUser(String userId);

    /**
     * 删除产品
     *
     * @param id
     * @return
     */
    int delete(String id);
}
