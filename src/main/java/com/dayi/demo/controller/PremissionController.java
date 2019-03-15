package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.Premission;
import com.dayi.demo.user.service.PremissionService;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-06
 */
@Controller
@RequestMapping("/premission")
public class PremissionController {

    @Resource
    private PremissionService premissionService;

    /**
     * 跳转权限管理页面
     *
     * @return
     */
    @RequestMapping("/premissionManger")
    public String premissionManager() {
        return "premissionManager";
    }

    /**
     * 添加权限
     *
     * @param premission
     * @return
     */
    @RequestMapping("/addPremission")
    @ResponseBody
    @RequiresPermissions("add:premission")
    public JSONObject addPremission(Premission premission) {
        JSONObject json = new JSONObject();
        int countAdd = premissionService.addPremission(premission);
        if (0 != countAdd) {
            json.put("success", "true");
        } else {
            json.put("success", "false");
            json.put("msg", "添加失败");
        }
        return json;
    }

    /**
     * 分页查找权限
     *
     * @param currentPage
     * @return
     */
    @RequestMapping("/findPremission")
    @ResponseBody
    @RequiresPermissions("select:premission")
    public PageInfo<Premission> findPremission(int currentPage) {
        return premissionService.findByPage(currentPage, 5);
    }

    /**
     * 查找权限菜单
     *
     * @return
     */
    @RequestMapping("/findPremissionMenu")
    @ResponseBody
    public List<Premission> findPremissionMenu() {
        List<Premission> list = premissionService.findPremissionMenu();
        return list;
    }

    /**
     * 更新权限
     *
     * @param premission
     * @return
     */
    @RequestMapping("/updatePremission")
    @ResponseBody
    @RequiresPermissions("update:premission")
    public JSONObject updatePremission(Premission premission) {
        JSONObject json = new JSONObject();
        int countAdd = premissionService.updatePremission(premission);
        if (0 != countAdd) {
            json.put("success", "true");
        } else {
            json.put("success", "false");
            json.put("msg", "更新失败");
        }
        return json;
    }

    /**
     * 返回所有权限（树状）
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/premissionTree")
    @ResponseBody
    public JSONArray premissionTree(String roleId) {
        System.out.println("roleId:" + roleId);
        return premissionService.doPremissionTree(roleId);
    }

    /**
     * 给角色授权
     *
     * @param roleId
     * @param premissions
     * @return
     */
    @RequestMapping("/authorization")
    @ResponseBody
    @RequiresPermissions("grant:premission")
    public JSONObject authorization(String roleId, String[] premissions) {
        JSONObject json = new JSONObject();
        int countAdd = premissionService.doAuthorization(roleId, premissions);
        boolean success = (0 != countAdd);
        json = JsonUtil.packageJson(success, "授权成功", "授权失败");
        return json;
    }

    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/deletePremission")
    @ResponseBody
    @RequiresPermissions("delete:premission")
    public JSONObject deletePremission(String id) {
        int countDelete = premissionService.deletePremission(id);
        boolean deleteSuccess = (0 != countDelete);
        return JsonUtil.packageJson(deleteSuccess, "删除成功", "删除失败");
    }

    /**
     * 查询当前用户是否拥有权限
     *
     * @param premission
     * @return
     */
    @RequestMapping("/hasPremission")
    @ResponseBody
    public boolean hasPremission(String premission) {
        return SecurityUtils.getSubject().isPermitted(premission);
    }

}
