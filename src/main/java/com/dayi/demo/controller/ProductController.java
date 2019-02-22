package com.dayi.demo.controller;

import com.dayi.demo.Utils.IdUtil;
import com.dayi.demo.product.dao.ProductDao;
import com.dayi.demo.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * 产品模块
 * @Author wut
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductDao productDao;

    /**
     * 跳转到产品添加页面
     * @return
     */
    @RequestMapping("/addProductPage")
    public String addProductPage() {return "addProduct";}

    /**
     * 添加产品
     * @return
     */
    @RequestMapping("/addProduct")
    public String addProduct() {
        Product product = new Product();
        product.setId(IdUtil.getPrimaryKey());
        product.setAddTime(new Date());
        product.setUpdateTime(new Date());
        product.setProductName("产品1");
        product.setProductPresentation("这是一个产品的描述");
        int c = productDao.addProduct(product);
        System.out.println(c);
        return "index";
    }


}
