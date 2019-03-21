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
    int countAllBug;

    /**
     * 未完成Bug数
     */
    int countBug;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getCountAllBug() {
        return countAllBug;
    }

    public void setCountAllBug(int countAllBug) {
        this.countAllBug = countAllBug;
    }

    public int getCountBug() {
        return countBug;
    }

    public void setCountBug(int countBug) {
        this.countBug = countBug;
    }
}
