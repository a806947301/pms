package com.dayi.demo.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-08
 */
public class JsonUtil {

    /**
     * 返回结果封装成Json对象
     * @param result
     * @param successMsg
     * @param errMsg
     * @return
     */
    public static JSONObject packageJson(boolean result, Object successMsg, Object errMsg) {
        JSONObject json = new JSONObject();
        if (result) {
            json.put("success", true);
            json.put("msg", successMsg);
        } else {
            json.put("success", false);
            json.put("msg", errMsg);
        }
        return json;
    }
}
