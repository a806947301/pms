package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
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
    public JSONObject addProduct(Product product, String[] participator) {
        //判断是否有空
        if (Product.hasEmpty(product, false)) {
            return JsonUtil.packageJson(false, "", "字段必须非空");
        }

        //添加产品
        String productId = null;
        try {
            productId = productService.add(product, participator);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, productId, "");
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
    public PageInfo<Product> findProduct(int currentPage, int pageSize) {
        return productService.findByPage(currentPage, pageSize);
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
    @RequiresPermissions("select:product")
    public Product getProduct(String id) {
        return productService.get(id);
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
    public JSONObject addProductParticipator(String id, String[] newParticipator) {
        //判断非空
        if (null == id || "".equals(id)) {
            return JsonUtil.packageJson(false, "", "id不能为空");
        }

        //添加参与者
        try {
            productService.addParticipator(id, newParticipator);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "添加成功", "");
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
    public JSONObject deleteProductParticipator(String productId, String userId) {
        //判断非空
        if (null == productId || "".equals(productId)) {
            return JsonUtil.packageJson(false, "", "产品不能为空");
        }
        if (null == userId || "".equals(userId)) {
            return JsonUtil.packageJson(false, "", "用户不能为空");
        }

        //删除产品成员
        try {
            productService.deleteParticipator(productId, userId);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "删除成员成功", "");
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
    public JSONObject updateProduct(Product product) {
        //判断非空
        if (Product.hasEmpty(product, true)) {
            return JsonUtil.packageJson(false, "", "字段必须非空");
        }

        //更新产品
        try {
            productService.update(product);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "更新产品成功", "");
    }

    /**
     * 查找所有产品
     *
     * @return
     */
    @RequestMapping("/findAllProduct")
    @ResponseBody
    public List<Product> findAllProduct() {
        return productService.findAll();
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
    public PageInfo<Product> findProductByCurrentUser(int currentPage, int pageSize) {
        User user = getCurrentUser();
        return productService.findByUser(user.getId(), currentPage, pageSize);
    }

}
