package com.dayi.demo.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 封装返回结果
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-08
 */
public class Result {

    /**
     * 是否成功
     */
    boolean success;

    /**
     * 返回的字符串
     */
    String msg;

    /**
     * 返回的数据
     */
    Object obj;

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Result(boolean success, String msg, Object obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public Result(boolean success, String successMsg, String errMsg, Object obj) {
        this.success = success;
        if (success) {
            this.msg = successMsg;
        } else {
            this.msg = errMsg;
        }

        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
