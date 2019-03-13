package com.dayi.demo.statistic.service;

import com.alibaba.fastjson.JSONArray;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-12
 */
public interface ProductStatisticService {

    /**
     * 统计产品信息
     *
     * @return
     */
    JSONArray doStatistic();

    /**
     * 产品信息导出Excel
     *
     * @param jsonArray 产品统计Json数组
     * @param out       输出excel文件的输出流
     * @throws IOException
     */
    void exportExcelProduct(JSONArray jsonArray, OutputStream out) throws IOException;

}
