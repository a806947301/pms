package com.dayi.demo.bug.model;

import com.dayi.demo.project.model.Project;
import com.dayi.demo.user.model.User;

import java.util.Date;

/**
 *
 * status状态说明：
 *          0.指派中
 * 	        1.处理中
 * 	        2.验收中
 * 	        3.已完成
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public class Bug {
    /** id */
    private String id;
    /** 创建时间 */
    private Date addTime;
    /** 更新时间 */
    private Date updateTime;
    /** 是否不予处理 */
    private boolean noProcessing;
    /** bug状态 */
    private int bugStatus;
    /** bug详情 */
    private String bugTitle;
    /** bug描述 */
    private String bugContent;
    /** bug提出者 */
    private User bugProposer;
    /** bug处理者 */
    private User bugProcesser;
    /** bug所属项目 */
    private Project project;

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

    public boolean isNoProcessing() {
        return noProcessing;
    }

    public void setNoProcessing(boolean noProcessing) {
        this.noProcessing = noProcessing;
    }

    public int getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(int bugStatus) {
        this.bugStatus = bugStatus;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle;
    }

    public String getBugContent() {
        return bugContent;
    }

    public void setBugContent(String bugContent) {
        this.bugContent = bugContent;
    }

    public User getBugProposer() {
        return bugProposer;
    }

    public void setBugProposer(User bugProposer) {
        this.bugProposer = bugProposer;
    }

    public User getBugProcesser() {
        return bugProcesser;
    }

    public void setBugProcesser(User bugProcesser) {
        this.bugProcesser = bugProcesser;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
