package com.dayi.demo.product.dao;

import com.dayi.demo.product.model.Product;
import org.springframework.stereotype.Repository;

/**
 * @Author wut
 */
public interface ProductDao {
    int addProduct(Product product);
}
