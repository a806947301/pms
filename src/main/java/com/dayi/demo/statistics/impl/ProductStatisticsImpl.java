package com.dayi.demo.statistics.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.statistics.ProductStatistics;
import com.dayi.demo.util.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-12
 */
@Component
public class ProductStatisticsImpl implements ProductStatistics {

    /**
     * 保存文件的相对路径
     */
    private static final String PATH = "\\excel\\product.xlsx";

    private Logger logger = LoggerFactory.getLogger(ProductStatisticsImpl.class);

    @Resource
    private ProductService productService;

    @Resource
    private ProjectService projectService;

    @Resource
    private BugService bugService;

    @Override
    public JSONArray doStatistic(String realpath) {
        JSONArray productJsonArray = new JSONArray();
        Map<String, JSONObject> productJsonMap = doPackageProductJsonMap();
        doAppendProject(productJsonMap);
        Set<Map.Entry<String, JSONObject>> productEntries = productJsonMap.entrySet();
        for (Map.Entry<String, JSONObject> productEntry : productEntries) {
            productJsonArray.add(productEntry.getValue());
        }
        try {
            ExcelUtil.exportExcelProduct(productJsonArray, realpath + PATH);
        } catch (Exception e) {
            logger.error(ExcelUtil.class.toString() + "_" + e.getMessage(), e);
        }
        return productJsonArray;
    }

    /**
     * 打包成map（key :产品id    value：产品json）
     * 产品json：
     * productName:String类型    产品的名称
     * product:JsonArray类型     产品下的项目，此时为空，等待添加
     *
     * @return
     */
    private Map<String, JSONObject> doPackageProductJsonMap() {
        List<Product> products = productService.findAllProduct();
        Map<String, JSONObject> productMap = new LinkedHashMap<String, JSONObject>();
        JSONObject productJson;
        for (Product product : products) {
            productJson = new JSONObject();
            productJson.put("productName", product.getProductName());
            productJson.put("projects", new LinkedList<Object>());
            productMap.put(product.getId(), productJson);
        }
        return productMap;
    }

    /**
     * 添加项目到产品Json上
     *
     * @param productJsonMap 商品json对应的map
     */
    private void doAppendProject(Map<String, JSONObject> productJsonMap) {
        Map<String, Integer> projectBugCountMap = bugService.countBugByProject();
        List<Project> projects = projectService.findAll();
        JSONObject projectJson;
        for (Project project : projects) {
            // 添加项目信息到json
            projectJson = new JSONObject();
            projectJson.put("projectName", project.getProjectName());
            projectJson.put("finished", project.isFinished());
            // 添加项目bug数到json
            int countBug = 0;
            Object countResult = projectBugCountMap.get(project.getId());
            if (countResult != null) {
                countBug = (int) countResult;
            }
            ;
            projectJson.put("countBug", countBug);
            // 添加项目json到产品json
            JSONObject productJson = productJsonMap.get(project.getProduct().getId());
            LinkedList<Object> projectList = (LinkedList<Object>) productJson.get("projects");
            projectList.add(projectJson);
        }
    }
}
