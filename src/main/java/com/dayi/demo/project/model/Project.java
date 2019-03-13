package com.dayi.demo.project.model;

import com.dayi.demo.product.model.Product;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-26
 */
public class Project {
    /** id */
    private String id;
    /** 创建时间 */
    private Date addTime;
    /** 更新时间 */
    private Date updateTime;
    /** 项目开始时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date beginDate;
    /** 项目结束时间 */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    /** 项目所属产品 */
    private Product product;
    /** 项目名 */
    private String projectName;
    /** 项目是否结束 */
    private boolean finished;

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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
