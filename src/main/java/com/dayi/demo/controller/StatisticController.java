package com.dayi.demo.controller;

import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.statistic.model.dto.ProductBugDto;
import com.dayi.demo.statistic.model.dto.UserBugDto;
import com.dayi.demo.statistic.service.UserStatisticService;
import com.dayi.demo.statistic.service.ProductStatisticService;
import com.dayi.demo.util.ExcelUtil;
import com.dayi.demo.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 统计模块控制器
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-13
 */
@Controller
@RequestMapping("/statistic")
public class StatisticController extends BaseController {

    /**
     * 导出产品Excel的文件名
     */
    private static final String PRODUCT_EXCEL_NAME = "product.xlsx";

    /**
     * 导出开发者Excel的文件名
     */
    private static final String DEVELOPER_EXCEL_NAME = "developer.xlsx";

    /**
     * 导出测试人员Excel的文件名
     */
    private static final String TESTER_EXCEL_NAME = "tester.xlsx";

    private final static Logger logger = LoggerFactory.getLogger(StatisticController.class);

    @Resource
    private ProductStatisticService productStatisticService;

    @Resource
    private UserStatisticService userStatisticService;

    /**
     * 跳转产品统计页面
     *
     * @return
     */
    @RequestMapping("/productStatisticPage")
    public String productStatisticPage() {
        return "productStatistic";
    }


    /**
     * 统计产品信息
     *
     * @return
     */
    @RequestMapping("/productStatistic")
    @ResponseBody
    @RequiresPermissions("products:statistic")
    public Result productStatistic(HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        List<ProductBugDto> list = productStatisticService.doStatistic();
        return new Result(true, "", list);
    }

    /**
     * 产品信息导出Excel
     *
     * @param response
     */
    @RequestMapping("/exportExcelProduct")
    @RequiresPermissions("products:statistic")
    public void exportExcelProduct(HttpServletResponse response) {
        //设置返回格式
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + PRODUCT_EXCEL_NAME);
        //返回Excel
        try {
            productStatisticService.exportExcelProduct(response.getOutputStream());
        } catch (IOException e) {
            logger.error(response.toString() + "_" + e.getMessage(), e);
        }

    }

    /**
     * 跳转开发人员统计页面
     *
     * @return
     */
    @RequestMapping("/developerStatisticPage")
    public String developerStatisticPage() {
        return "developerStatistic";
    }

    /**
     * 统计开发人员信息
     *
     * @return
     */
    @RequestMapping("/developerStatistic")
    @ResponseBody
    @RequiresPermissions("developer:statistic")
    public Result developerStatistic() {
        List<UserBugDto> list = userStatisticService.doStatisicDeveloper();
        return new Result(true, "", list);
    }

    /**
     * 导出开发人员统计Excel
     *
     * @param response
     */
    @RequestMapping("/exportExcelDevloper")
    @RequiresPermissions("developer:statistic")
    public void exportExcelDeveloper(HttpServletResponse response) {
        //设置返回格式
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + DEVELOPER_EXCEL_NAME);

        //返回Excel
        try {
            userStatisticService.exportExcelDeveloper(response.getOutputStream());
        } catch (IOException e) {
            logger.error(response + "_" + e.getMessage(), e);
        }
    }

    /**
     * 跳转测试人员统计页面
     *
     * @return
     */
    @RequestMapping("/testerStatisticPage")
    public String testerStatisticPage() {
        return "testerStatistic";
    }

    /**
     * 统计测试人员信息
     *
     * @return
     */
    @RequestMapping("/testerStatistic")
    @ResponseBody
    @RequiresPermissions("test:statistic")
    public Result testerStatistic() {
        List<UserBugDto> list = userStatisticService.doStatisicTester();
        return new Result(true, "", list);
    }

    /**
     * 导出测试人员统计Excel
     *
     * @param response
     */
    @RequestMapping("/exportExcelTester")
    @RequiresPermissions("test:statistic")
    public void exportExcelTester(HttpServletResponse response) {
        //设置返回格式
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + TESTER_EXCEL_NAME);

        //返回Excel
        try {
            userStatisticService.exportExcelTester(response.getOutputStream());
        } catch (IOException e) {
            logger.error(response + "_" + e.getMessage(), e);
        }
    }
}
