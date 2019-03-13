package com.dayi.demo.statistic.service;

import com.alibaba.fastjson.JSONArray;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-03-13
 */
public interface UserStatistic {

    /**
     * 统计开发人员，并以Json形式返回
     * @return
     */
    JSONArray doStatisicDeveloper();

    /**
     * 统计测试人员，并以Json形式返回
     * @return
     */
    JSONArray doStatisicTester();

    /**
     * 开发人员统计Json导出Excel
     * @param out
     * @throws IOException
     */
    void exportExcelDeveloper(OutputStream out)throws IOException;

    /**
     * 测试人员统计Json导出Excel
     * @param out
     * @throws IOException
     */
    void exportExcelTester(OutputStream out)throws IOException;
}
