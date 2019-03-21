package com.dayi.demo.statistic.dto;

import java.util.List;

/**
 * 产品 Dto
 *
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-03-21
 */
public class ProductBugDto {
    /**
     * 产品名
     */
    String productName;

    /**
     * 产品下项目
     */
    List<ProjectBugDto> projects;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ProjectBugDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectBugDto> projects) {
        this.projects = projects;
    }
}
