package com.dayi.demo.bug.model;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.user.model.User;

import javax.swing.text.html.parser.Entity;
import java.util.Date;

/**
 * Bug POJO类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
public class Bug extends BaseEntity {

    /**
     * Bug状态枚举类
     */
    public enum Status {
        /**
         * 指派中
         */
        DESIGNATE(0),
        /**
         * 处理中
         */
        PROCESSER(1),
        /**
         * 验收中
         */
        CHECKING(2),
        /**
         * 已完成
         */
        FINISHED(3);

        private final int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 是否不予处理
     */
    private Boolean noProcessing;
    /**
     * bug状态
     */
    private Integer bugStatus;
    /**
     * bug详情
     */
    private String bugTitle;
    /**
     * bug描述
     */
    private String bugContent;
    /**
     * bug提出者
     */
    private User bugProposer;
    /**
     * bug处理者
     */
    private User bugProcesser;
    /**
     * bug所属项目
     */
    private Project project;

    public Boolean getNoProcessing() {
        return noProcessing;
    }

    public void setNoProcessing(Boolean noProcessing) {
        this.noProcessing = noProcessing;
    }

    public Integer getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(Integer bugStatus) {
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

    /**
     * 判断Bug是否有空字段
     *
     * @param bug
     * @param includeId       是否包含id
     * @param includeProposer 是否包含Bug提出者
     * @return
     */
    public static boolean hasEmpty(Bug bug, boolean includeId, boolean includeProposer) {
        if (BaseEntity.hasEmpty(bug,includeId)) {
            return true;
        }
        if (null == bug.getBugTitle() || "".equals(bug.getBugTitle())) {
            return true;
        }
        if (null == bug.getBugContent() || "".equals(bug.getBugContent())) {
            return true;
        }
        if (includeProposer && null == bug.getBugProposer()) {
            return true;
        }
        boolean emptyProposerId = includeProposer &&
                (null == bug.getBugProposer().getId() || "".equals(bug.getBugProposer().getId()));
        if (emptyProposerId) {
            return true;
        }
        if (null == bug.getBugProcesser() && includeProposer) {
            return true;
        }
        boolean checkingProposer = includeProposer && null == bug.getBugProcesser().getId() ||
                "".equals(bug.getBugProcesser().getId());
        if (checkingProposer) {
            return true;
        }
        if (null == bug.getProject()) {
            return true;
        }
        if (null == bug.getProject().getId() || "".equals(bug.getProject().getId())) {
            return true;
        }
        return false;
    }
}
