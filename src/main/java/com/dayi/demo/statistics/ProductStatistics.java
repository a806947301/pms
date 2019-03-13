package com.dayi.demo.statistics;

import com.alibaba.fastjson.JSONArray;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.project.service.ProjectService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author wut
 * @Date 2019-03-12
 */
public interface ProductStatistics {

    /**
     * 统计产品信息
     *
     * @param realpath
     * @return
     */
    public JSONArray doStatistic(String realpath);

}
