package com.dayi.demo.project.model;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.product.model.Product;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 项目 POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-26
 */
public class Project extends BaseEntity {
    /**
     * 项目开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    /**
     * 项目结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    /**
     * 项目所属产品
     */
    private Product product;
    /**
     * 项目名
     */
    private String projectName;
    /**
     * 项目是否结束
     */
    private Boolean finished;

    @Override
    public String toString() {
        return "Project{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", product=" + product +
                ", projectName='" + projectName + '\'' +
                ", finished=" + finished +
                '}';
    }

    /**
     * 判断项目是否有空字段
     * @param project
     * @param includingId
     * @return
     */
    public static boolean hasEmpty(Project project, boolean includingId) {
        if (BaseEntity.hasEmpty(project, includingId)) {
            return true;
        }
        if (null == project.getBeginDate()) {
            return true;
        }
        if (null == project.getEndDate()) {
            return true;
        }
        if (null == project.getProduct()) {
            return true;
        }
        String productId = project.getProduct().getId();
        if (null == productId || "".equals(productId)) {
            return true;
        }
        if (null == project.getProjectName() || "".equals(project.getProjectName())) {
            return true;
        }
        return false;
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

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
