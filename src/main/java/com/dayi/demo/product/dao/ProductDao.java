package com.dayi.demo.product.dao;

import com.dayi.demo.product.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author wut
 */
public interface ProductDao {
    int addProduct(Product product);
    int addProductParticipator(@Param("id")String id, @Param("productId") String productId, @Param("userId") String userId
            , @Param("addTime")Date addTime,@Param("updateTime") Date updateTime);
    List<Product> findAllProduct();
    Product getProduct(String id);
    int deleteParticipator(@Param("productId")String productId,@Param("userId")String userId);
    int updateProduct(Product product);
}
