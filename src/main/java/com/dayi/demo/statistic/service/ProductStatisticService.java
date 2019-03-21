package com.dayi.demo.statistic.service;

import com.dayi.demo.statistic.dto.ProductBugDto;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 产品统计模块Service层接口
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-12
 */
public interface ProductStatisticService {

    /**
     * 统计产品信息
     *
     * @return
     */
    List<ProductBugDto> doStatistic();

    /**
     * 产品信息导出Excel
     *
     * @param out       输出excel文件的输出流
     * @throws IOException
     */
    void exportExcelProduct(OutputStream out) throws IOException;

}
