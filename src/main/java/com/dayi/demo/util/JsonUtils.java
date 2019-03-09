package com.dayi.demo.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author wut
 * @Date 2019-03-08
 */
public class JsonUtils {
    public static JSONObject packageJson(boolean result,String successMsg,String errMsg) {
        JSONObject json = new JSONObject();
        if(result) {
            json.put("success",true);
            json.put("msg",successMsg);
        } else {
            json.put("success",false);
            json.put("msg",errMsg);
        }
        return json;
    }
}
