package com.dayi.demo.bug.model;

import com.dayi.demo.common.entity.BaseEntity;

import java.util.Date;

/**
 * Bug说明 POJO类
 *
 * @author WuTong<wut   @   pvc123.com>
 * @date 2019-2-28
 */
public class BugDescription extends BaseEntity {

    /**
     * 所属Bug id
     */
    private String bugId;
    /**
     * 说明内容
     */
    private String content;

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

    /**
     * 判断是否有字段为空
     * @param bugDescription
     * @param includeId
     * @return
     */
    public static boolean hasEmpty(BugDescription bugDescription, boolean includeId) {
        if (BaseEntity.hasEmpty(bugDescription,includeId)) {
            return true;
        }
        if (null == bugDescription.getContent() || "".equals(bugDescription.getContent())) {
            return true;
        }
        return false;
    }
}
