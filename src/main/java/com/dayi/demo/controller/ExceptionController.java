package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * 异常控制器，负责返回异常信息
 *
 * @author WuTong<wut   @   pvc123.com>
 * @date 2019-03-14
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController extends BaseController {

    /**
     * 没有权限异常信息
     *
     * @return
     */
    @RequestMapping("/haveNotPremission")
    @ResponseBody
    public JSONObject haveNotPremission() {
        return JsonUtil.packageJson(false, "", "你没有权限");
    }

    /**
     * 数据库异常
     *
     * @return
     */
    @RequestMapping("/sqlException")
    @ResponseBody
    public JSONObject sqlException() {
        return JsonUtil.packageJson(false, "", "数据库出现异常");
    }

    /**
     * 文件上传异常
     *
     * @return
     */
    @RequestMapping("/maxUploadException")
    @ResponseBody
    public JSONObject maxUploadException() {
        return JsonUtil.packageJson(false, "", "文件名过长");
    }

    @RequestMapping("/otherException")
    @ResponseBody
    public JSONObject otherException() {
        return JsonUtil.packageJson(false, "", "其他异常");
    }
}
