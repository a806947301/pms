package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.Permission;
import com.dayi.demo.user.service.PermissionService;
import com.dayi.demo.util.Result;
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
    public Result addPermission(Permission permission) {
        //判断是否有空字段
        if (Permission.hasEmpty(permission, false)) {
            return new Result(false, "字段不能为空");
        }

        //添加权限
        try {
            permissionService.add(permission);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "添加权限成功");
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
    public Result findPermission(int currentPage, int pageSize) {
        PageInfo<Permission> pageInfo = permissionService.findByPage(currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 查找权限菜单
     *
     * @return
     */
    @RequestMapping("/findPermissionMenu")
    @ResponseBody
    public Result findPermissionMenu() {
        List<Permission> list = permissionService.findPermissionMenu();
        return new Result(true, "", list);
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
    public Result updatePermission(Permission permission) {
        //判断非空
        if (Permission.hasEmpty(permission, true)) {
            return new Result(false, "字段不能为空");
        }

        //更新权限
        try {
            permissionService.update(permission);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "更新权限成功");
    }

    /**
     * 返回所有权限（树状）
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/permissionTree")
    @ResponseBody
    public Result permissionTree(String roleId) {
        JSONArray tree = permissionService.doPermissionTree(roleId);
        return new Result(true, "", tree);
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
    public Result authorization(String roleId, String[] permissions) {
        //判断非空
        if (null == roleId || "".equals(roleId)) {
            return new Result(false, "授权失败");
        }

        //授权
        permissionService.doAuthorization(roleId, permissions);
        return new Result(true, "授权成功");
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
    public Result deletePermission(String id) {
        //判断非空
        if (null == id || "".equals(id)) {
            return new Result(false, "id不能为空");
        }

        //删除权限
        try {
            permissionService.delete(id);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "删除权限成功");
    }

}
