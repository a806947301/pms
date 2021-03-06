package com.dayi.demo.product.model;

import com.dayi.demo.common.entity.BaseEntity;

import java.util.Date;

/**
 * 产品 POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
public class Product extends BaseEntity {

    /**
     * 产品名
     */
    private String productName;
    /**
     * 产品介绍
     */
    private String productPresentation;

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPresentation='" + productPresentation + '\'' +
                ", id='" + id + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    /**
     * 判断产品是否有空字段
     *
     * @param product
     * @param includingId
     * @return
     */
    public static boolean hasEmpty(Product product, boolean includingId) {
        if (BaseEntity.hasEmpty(product, includingId)) {
            return true;
        }
        if (null == product.getProductName() || "".equals(product.getProductName())) {
            return true;
        }
        if (null == product.getProductPresentation() || "".equals(product.getProductPresentation())) {
            return true;
        }
        return false;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPresentation() {
        return productPresentation;
    }

    public void setProductPresentation(String productPresentation) {
        this.productPresentation = productPresentation;
    }

}
