package com.dayi.demo.statistic.model.vo;

/**
 * 用户Bug Vo
 *
 * @author WuTong<wut@pvc123.com>
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
    private Integer bugNumber;

    /**
     * 指派中数量
     */
    private Integer designate;

    /**
     * 验收中数量
     */
    private Integer checking;

    /**
     * 已完成数量
     */
    private Integer finished;

    @Override
    public String toString() {
        return "UserBugVo{" +
                "userId='" + userId + '\'' +
                ", bugNumber=" + bugNumber +
                ", designate=" + designate +
                ", checking=" + checking +
                ", finished=" + finished +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBugNumber() {
        return bugNumber;
    }

    public void setBugNumber(Integer bugNumber) {
        this.bugNumber = bugNumber;
    }

    public Integer getDesignate() {
        return designate;
    }

    public void setDesignate(Integer designate) {
        this.designate = designate;
    }

    public Integer getChecking() {
        return checking;
    }

    public void setChecking(Integer checking) {
        this.checking = checking;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }
}
