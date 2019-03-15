package com.dayi.demo.product.dao;

import com.dayi.demo.product.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-2-25
 */
public interface ProductDao {

    /**
     * 添加产品
     *
     * @param product
     * @return
     */
    int addProduct(Product product);

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
    int addProductParticipator(@Param("id") String id,
                               @Param("productId") String productId,
                               @Param("userId") String userId,
                               @Param("addTime") Date addTime,
                               @Param("updateTime") Date updateTime);

    /**
     * 查找所有产品
     *
     * @return
     */
    List<Product> findAllProduct();

    /**
     * 获取指定产品
     *
     * @param id
     * @return
     */
    Product getProduct(String id);

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
    int updateProduct(Product product);

    /**
     * 查找用户参与的产品
     *
     * @param userId
     * @return
     */
    List<Product> findProductByUser(String userId);
}
