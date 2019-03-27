package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.util.Result;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品模块控制器
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Resource
    private ProductService productService;

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
     * 添加产品
     *
     * @return
     */
    @RequestMapping("/addProduct")
    @ResponseBody
    @RequiresPermissions("add:product")
    public Result addProduct(Product product, String[] participator) {
        //判断是否有空
        if (Product.hasEmpty(product, false)) {
            return new Result(false, "字段必须不为空");
        }

        //添加产品
        String productId = null;
        try {
            productId = productService.add(product, participator);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, productId);
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
    @RequiresPermissions("select:product")
    public Result findProduct(int currentPage, int pageSize) {
        PageInfo<Product> pageInfo = productService.findByPage(currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 跳转产品页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getProductPage/{id}")
    public String gerProductPage(@PathVariable("id") String id) {
        return "getProduct";
    }

    /**
     * 获取产品信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/getProduct")
    @ResponseBody
    @RequiresPermissions("select:product")
    public Result getProduct(String id) {
        Product product = productService.get(id);
        return new Result(true, "", product);
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
    @RequiresPermissions("addUser:product")
    public Result addProductParticipator(String id, String[] newParticipator) {
        //判断非空
        if (null == id || "".equals(id)) {
            return new Result(false, "字段必须不为空");
        }

        //添加参与者
        try {
            productService.addParticipator(id, newParticipator);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "添加成功");
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
    @RequiresPermissions("addUser:product")
    public Result deleteProductParticipator(String productId, String userId) {
        //判断非空
        if (null == productId || "".equals(productId)) {
            return new Result(false, "产品不能为空");
        }
        if (null == userId || "".equals(userId)) {
            return new Result(false, "用户不能为空");
        }

        //删除产品成员
        try {
            productService.deleteParticipator(productId, userId);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "删除成员成功");
    }

    /**
     * 更新产品信息
     *
     * @param product
     * @return
     */
    @RequestMapping("/updateProduct")
    @ResponseBody
    @RequiresPermissions("update:product")
    public Result updateProduct(Product product) {
        //判断非空
        if (Product.hasEmpty(product, true)) {
            return new Result(false, "字段必须不为空");
        }

        //更新产品
        try {
            productService.update(product);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "更新产品成功");
    }

    /**
     * 查找所有产品
     *
     * @return
     */
    @RequestMapping("/findAllProduct")
    @ResponseBody
    public Result findAllProduct() {
        List<Product> list = productService.findAll();
        return new Result(true, "", list);
    }

    /**
     * 查找当前用户参与的产品
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findProductByCurrentUser")
    @ResponseBody
    public Result findProductByCurrentUser(int currentPage, int pageSize) {
        User user = getCurrentUser();
        PageInfo<Product> pageInfo = productService.findByUser(user.getId(), currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 删除产品
     *
     * @param productId
     * @return
     */
    @RequestMapping("/deleteProduct")
    @ResponseBody
    @RequiresPermissions("delete:product")
    public Result deleteProduct(String productId) {
        //判断非空
        if (null == productId || "".equals(productId)) {
            return new Result(false, "产品Id不能为空");
        }

        //删除产品
        try {
            productService.delete(productId);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "删除产品成功");
    }
}
