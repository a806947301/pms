package com.dayi.demo.statistic.dto;

import com.dayi.demo.statistic.vo.UserBugVo;

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
            this.setUserId(vo.getUserId());
            this.setBugNumber(vo.getBugNumber());
            this.setChecking(vo.getChecking());
            this.setDesignate(vo.getDesignate());
            this.setFinished(vo.getFinished());
            this.setProcessing(vo.getProcessing());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
