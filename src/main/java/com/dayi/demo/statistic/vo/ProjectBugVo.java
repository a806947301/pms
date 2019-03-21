package com.dayi.demo.statistic.vo;

/**
 *项目Bug Vo
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-21
 */
public class ProjectBugVo {
    /**
     * 项目Id
     */
    String projectId;

    /**
     * Bug总数
     */
    Integer countAllBug;

    /**
     * 未完成Bug数
     */
    Integer countBug;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getCountAllBug() {
        return countAllBug;
    }

    public void setCountAllBug(Integer countAllBug) {
        this.countAllBug = countAllBug;
    }

    public Integer getCountBug() {
        return countBug;
    }

    public void setCountBug(Integer countBug) {
        this.countBug = countBug;
    }
}
