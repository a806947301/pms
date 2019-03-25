package com.dayi.demo.statistic.model.dto;

import com.dayi.demo.statistic.model.vo.UserBugVo;

/**
 * 用户Bug Dto
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-21
 */
public class UserBugDto extends UserBugVo {
    /**
     * 姓名
     */
    String name;

    public UserBugDto() {
    }

    public UserBugDto(UserBugVo vo) {
        //如果vo不为空，则复制vo属性
        if (null != vo) {
            this.setBugNumber(vo.getBugNumber());
            this.setChecking(vo.getChecking());
            this.setDesignate(vo.getDesignate());
            this.setFinished(vo.getFinished());
            this.setProcessing(vo.getProcessing());
            return;
        }

        //如果为空，则全部设置为0
        this.setBugNumber(0);
        this.setChecking(0);
        this.setDesignate(0);
        this.setFinished(0);
        this.setProcessing(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
