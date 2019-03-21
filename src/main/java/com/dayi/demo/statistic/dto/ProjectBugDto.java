package com.dayi.demo.statistic.dto;

import com.dayi.demo.statistic.vo.ProjectBugVo;

/**
 * 项目Bug Dto
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-21
 */
public class ProjectBugDto extends ProjectBugVo {
    /**
     * 项目名
     */
    String projectName;

    /**
     * 完成状态
     */
    boolean finished;

    public ProjectBugDto() { }

    public ProjectBugDto(ProjectBugVo vo) {
        //如果vo不为空，则复制vo字段
        if (null != vo) {
            this.setProjectId(vo.getProjectId());
            this.setCountAllBug(vo.getCountAllBug());
            this.setCountBug(vo.getCountBug());
            return;
        }

    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
