package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.Permission;
import com.dayi.demo.user.service.PermissionService;
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
 * 权限控制器
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-06
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Resource
    private PermissionService permissionService;

    /**
     * 跳转权限管理页面
     *
     * @return
     */
    @RequestMapping("/permissionManger")
    public String permissionManager() {
        return "permissionManager";
    }

    /**
     * 添加权限
     *
     * @param permission
     * @return
     */
    @RequestMapping("/addPermission")
    @ResponseBody
    @RequiresPermissions("add:permission")
    public JSONObject addPermission(Permission permission) {
        //判断是否有空字段
        if (Permission.hasEmpty(permission, false)) {
            return JsonUtil.packageJson(false, "", "有字段为空");
        }

        //添加权限
        try {
            permissionService.add(permission);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "添加权限成功", "");
    }

    /**
     * 分页查找权限
     *
     * @param currentPage
     * @return
     */
    @RequestMapping("/findPermission")
    @ResponseBody
    @RequiresPermissions("select:permission")
    public PageInfo<Permission> findPermission(int currentPage) {
        return permissionService.findByPage(currentPage, 5);
    }

    /**
     * 查找权限菜单
     *
     * @return
     */
    @RequestMapping("/findPermissionMenu")
    @ResponseBody
    public List<Permission> findPermissionMenu() {
        List<Permission> list = permissionService.findPermissionMenu();
        return list;
    }

    /**
     * 更新权限
     *
     * @param permission
     * @return
     */
    @RequestMapping("/updatePermission")
    @ResponseBody
    @RequiresPermissions("update:permission")
    public JSONObject updatePermission(Permission permission) {
        //判断非空
        if (Permission.hasEmpty(permission, true)) {
            return JsonUtil.packageJson(false, "", "有字段为空");
        }

        //更新权限
        try {
            permissionService.update(permission);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "更新权限成功", "");
    }

    /**
     * 返回所有权限（树状）
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/permissionTree")
    @ResponseBody
    public JSONArray permissionTree(String roleId) {
        return permissionService.doPermissionTree(roleId);
    }

    /**
     * 给角色授权
     *
     * @param roleId
     * @param permissions
     * @return
     */
    @RequestMapping("/authorization")
    @ResponseBody
    @RequiresPermissions("grant:permission")
    public JSONObject authorization(String roleId, String[] permissions) {
        //判断非空
        if (null == roleId || "".equals(roleId)) {
            return JsonUtil.packageJson(false, "", "授权失败");
        }

        //授权
        permissionService.doAuthorization(roleId, permissions);
        return JsonUtil.packageJson(true, "授权成功", "");
    }

    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/deletePermission")
    @ResponseBody
    @RequiresPermissions("delete:permission")
    public JSONObject deletePermission(String id) {
        //判断非空
        if (null == id || "".equals(id)) {
            return JsonUtil.packageJson(false, "", "id不能为空");
        }

        //删除权限
        try {
            permissionService.delete(id);
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "删除权限成功", "");
    }

    /**
     * 查询当前用户是否拥有权限
     *
     * @param permission
     * @return
     */
    @RequestMapping("/hasPermission")
    @ResponseBody
    public boolean hasPermission(String permission) {
        return SecurityUtils.getSubject().isPermitted(permission);
    }

}
