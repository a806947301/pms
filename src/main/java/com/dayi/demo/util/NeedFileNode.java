package com.dayi.demo.util;

import java.util.List;

/**
 * 需求文件节点，用于遍历需求文件文件夹
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-27
 */
public class NeedFileNode {
    /**
     * 文件路径
     */
    private String file;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 是否目录
     */
    private boolean direction;

    /**
     * 子文件
     */
    private List<NeedFileNode> children;

    public NeedFileNode() {
    }

    public NeedFileNode(String file, String fileName, boolean direction, List<NeedFileNode> children) {
        this.file = file;
        this.fileName = fileName;
        this.direction = direction;
        this.children = children;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public List<NeedFileNode> getChildren() {
        return children;
    }

    public void setChildren(List<NeedFileNode> children) {
        this.children = children;
    }
}
