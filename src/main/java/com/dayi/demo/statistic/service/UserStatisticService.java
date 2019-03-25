package com.dayi.demo.statistic.service;

import com.dayi.demo.statistic.model.dto.UserBugDto;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 用户统计模块Service层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-13
 */
public interface UserStatisticService {

    /**
     * 统计开发人员，并以Json形式返回
     * @return
     */
    List<UserBugDto> doStatisicDeveloper();

    /**
     * 统计测试人员，并以Json形式返回
     * @return
     */
    List<UserBugDto> doStatisicTester();

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
