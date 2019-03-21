package com.dayi.demo.statistic.vo;

/**
 * 用户Bug Vo
 *
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-03-21
 */
public class UserBugVo {
    /**
     * 用户id
     */
    private String userId;

    /**
     * Bug总数
     */
    private int bugNumber;

    /**
     * 指派中数量
     */
    private int designate;

    /**
     * 处理中数量
     */
    private int processing;

    /**
     * 验收中数量
     */
    private int checking;

    /**
     * 已完成数量
     */
    private int finished;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBugNumber() {
        return bugNumber;
    }

    public void setBugNumber(int bugNumber) {
        this.bugNumber = bugNumber;
    }

    public int getDesignate() {
        return designate;
    }

    public void setDesignate(int designate) {
        this.designate = designate;
    }

    public int getProcessing() {
        return processing;
    }

    public void setProcessing(int processing) {
        this.processing = processing;
    }

    public int getChecking() {
        return checking;
    }

    public void setChecking(int checking) {
        this.checking = checking;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }
}
