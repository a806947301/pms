package com.dayi.demo.product.model;

import java.util.Date;

/**
 * @Author wut
 */
public class Product {
    /** id */
    private String id;
    /** 创建时间 */
    private Date addTime;
    /** 更新时间 */
    private Date updateTime;
    /** 产品名 */
    private String productName;
    /** 产品介绍 */
    private String productPresentation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
