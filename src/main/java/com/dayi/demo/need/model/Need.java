package com.dayi.demo.need.model;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.user.model.User;


/**
 * 需求 POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-04
 */
public class Need extends BaseEntity {

    /**
     * 需求名
     */
    private String needName;
    /**
     * 需求描述
     */
    private String needDescription;
    /**
     * 说明文件地址
     */
    private String descriptionFilepath;
    /**
     * 需求文件地址
     */
    private String needFilepath;
    /**
     * 需求提出者
     */
    private User user;
    /**
     * 需求所属项目
     */
    private Project project;
    /**
     * 说明文件文件名
     */
    private String descriptionFilename;
    /**
     * 需求文件文件名
     */
    private String needFilename;

    @Override
    public String toString() {
        return "Need{" +
                "needName='" + needName + '\'' +
                ", needDescription='" + needDescription + '\'' +
                ", descriptionFilepath='" + descriptionFilepath + '\'' +
                ", needFilepath='" + needFilepath + '\'' +
                ", user=" + user +
                ", project=" + project +
                ", descriptionFilename='" + descriptionFilename + '\'' +
                ", needFilename='" + needFilename + '\'' +
                ", id='" + id + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getNeedName() {
        return needName;
    }

    public void setNeedName(String needName) {
        this.needName = needName;
    }

    public String getNeedDescription() {
        return needDescription;
    }

    public void setNeedDescription(String needDescription) {
        this.needDescription = needDescription;
    }

    public String getDescriptionFilepath() {
        return descriptionFilepath;
    }

    public void setDescriptionFilepath(String descriptionFilepath) {
        this.descriptionFilepath = descriptionFilepath;
    }

    public String getNeedFilepath() {
        return needFilepath;
    }

    public void setNeedFilepath(String needFilepath) {
        this.needFilepath = needFilepath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescriptionFilename() {
        return descriptionFilename;
    }

    public void setDescriptionFilename(String descriptionFilename) {
        this.descriptionFilename = descriptionFilename;
    }

    public String getNeedFilename() {
        return needFilename;
    }

    public void setNeedFilename(String needFilename) {
        this.needFilename = needFilename;
    }
}
