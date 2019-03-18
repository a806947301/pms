package com.dayi.demo.product.model;

import com.dayi.demo.common.entity.BaseEntity;

import java.util.Date;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
public class Product extends BaseEntity {

    /** 产品名 */
    private String productName;
    /** 产品介绍 */
    private String productPresentation;

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
