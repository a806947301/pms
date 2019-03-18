package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-03-14
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController extends BaseController {

    /**
     * 没有权限异常信息
     * @return
     */
    @RequestMapping("/haveNotPremission")
    @ResponseBody
    public JSONObject haveNotPremission () {
        return JsonUtil.packageJson(false,"","你没有权限");
    }

    @RequestMapping("/mybatisException")
    @ResponseBody
    public JSONObject mybatisException() {
        return JsonUtil.packageJson(false,"","数据库出现异常");
    }

}
