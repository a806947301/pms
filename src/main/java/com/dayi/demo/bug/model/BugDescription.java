package com.dayi.demo.bug.model;

import java.util.Date;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public class BugDescription {
    /** id */
    private String id;
    /** 创建时间 */
    private Date addTime;
    /** 更新时间 */
    private Date updateTime;
    /** 所属Bug id */
    private String bugId;
    /** 说明内容 */
    private String content;

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

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
