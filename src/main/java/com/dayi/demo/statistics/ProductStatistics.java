package com.dayi.demo.statistics;

import com.alibaba.fastjson.JSONArray;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-12
 */
public interface ProductStatistics {

    /**
     * 统计产品信息
     *
     * @param realpath
     * @return
     */
    JSONArray doStatistic(String realpath);

}
