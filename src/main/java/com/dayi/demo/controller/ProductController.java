package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.statistics.ProductStatistics;
import com.dayi.demo.user.model.User;
import com.dayi.demo.util.IdUtils;
import com.dayi.demo.product.dao.ProductDao;
import com.dayi.demo.product.model.Product;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 产品模块控制器
 *
 * @Author wut
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private ProductStatistics productStatistics;

    /**
     * 跳转到产品添加页面
     *
     * @return
     */
    @RequestMapping("/addProductPage")
    public String addProductPage() {
        return "addProduct";
    }

    /**
     * 跳转产品统计页面
     *
     * @return
     */
    @RequestMapping("/productStatisticsPage")
    public String productStatisticsPage() {
        return "productStatistics";
    }

    /**
     * 添加产品
     *
     * @return
     */
    @RequestMapping("/addProduct")
    @ResponseBody
    public String addProduct(Product product, String[] participator) {
        return productService.addProduct(product, participator);
    }

    /**
     * 跳转产品列表页面
     *
     * @return
     */
    @RequestMapping("/findProductPage")
    public String productList() {
        return "productList";
    }

    /**
     * 分页查询产品
     *
     * @param currentPage
     * @return
     */
    @RequestMapping("/findProduct")
    @ResponseBody
    public PageInfo<Product> findProduct(int currentPage) {
        return productService.findByPage(currentPage, 5);
    }

    /**
     * 跳转产品页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getProductPage/{id}")
    public String gerProductPage(String id) {
        return "getProduct";
    }

    /**
     * 获取产品组成员
     *
     * @param id 产品id
     * @return
     */
    @RequestMapping("/getProductParticipator")
    @ResponseBody
    public List<User> getProductParticipator(String id) {
        return productService.getParticipator(id);
    }

    /**
     * 获取产品信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/getProduct")
    @ResponseBody
    public Product getProduct(String id) {
        return productService.getProduct(id);
    }

    /**
     * 添加产品组成员
     *
     * @param id
     * @param newParticipator
     * @return
     */
    @RequestMapping("/addProductParticipator")
    @ResponseBody
    public int addProductParticipator(String id, String[] newParticipator) {
        return productService.addParticipator(id, newParticipator);
    }

    /**
     * 删除产品成员
     *
     * @param productId
     * @param userId
     * @return
     */
    @RequestMapping("/deleteProductParticipator")
    @ResponseBody
    public int deleteProductParticipator(String productId, String userId) {
        return productService.deleteParticipator(productId, userId);
    }

    /**
     * 更新产品信息
     *
     * @param product
     * @return
     */
    @RequestMapping("/updateProduct")
    @ResponseBody
    public int updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    /**
     * 查找所有产品
     *
     * @return
     */
    @RequestMapping("/findAllProduct")
    @ResponseBody
    public List<Product> findAllProduct() {
        return productService.findAllProduct();
    }

    /**
     * 统计产品信息
     *
     * @return
     */
    @RequestMapping("/productStatistics")
    @ResponseBody
    public JSONArray productStatistics(HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        return productStatistics.doStatistic(realPath);
    }

}
