package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.user.model.Role;
import com.dayi.demo.user.service.RoleService;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WuTong<wut @ pvc123.com>
 * @date 2019-03-06
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private RoleService roleService;

    /**
     * 跳转角色管理页面
     *
     * @return
     */
    @RequestMapping("/roleManager")
    public String roleManagerPage() {
        return "roleManager";
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    @ResponseBody
    @RequiresPermissions("add:role")
    public JSONObject addRole(Role role) {
        //判断非空
        if (Role.hasEmpty(role, false)) {
            return JsonUtil.packageJson(true, "", "字段必须非空");
        }

        //添加角色
        try {
            roleService.add(role);
        } catch (Exception e) {
            logger.error(RoleController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false, "", "添加角色失败");
        }
        return JsonUtil.packageJson(true, "添加成功", "");
    }

    /**
     * 更新角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/updateRole")
    @ResponseBody
    @RequiresPermissions("update:role")
    public JSONObject updateRole(Role role) {
        // 判断字段是否为空
        if (Role.hasEmpty(role, true)) {
            return JsonUtil.packageJson(true, "", "字段必须非空");
        }

        //更新角色
        try {
            roleService.update(role);
        } catch (Exception e) {
            logger.error(RoleController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false, "", "更新角色失败");
        }
        return JsonUtil.packageJson(true, "更新成功", "");
    }

    /**
     * 分页查找角色
     *
     * @param currentPage
     * @return
     */
    @RequestMapping("/findRole")
    @ResponseBody
    @RequiresPermissions("select:role")
    public PageInfo<Role> findRole(int currentPage) {
        return roleService.findByPage(currentPage, 5);
    }

    /**
     * 查找所有角色
     *
     * @return
     */
    @RequestMapping("/findAllRole")
    @ResponseBody
    public List<Role> findAllRole() {
        return roleService.findAll();
    }

    /**
     * 查找用户拥有的角色
     *
     * @param userId
     * @return
     */
    @RequestMapping("/findRoleByUserId")
    @ResponseBody
    public List<Role> findRoleByUserId(String userId) {
        return roleService.findRoleByUserId(userId);
    }

    /**
     * 获取指定角色名的角色
     *
     * @param rolename
     * @return
     */
    @RequestMapping("/getRoleByRoleName")
    @ResponseBody
    public Role getRoleByRoleName(String rolename) {
        return roleService.getRoleByRoleName(rolename);
    }

    /**
     * 把角色赋予用户
     *
     * @param userId
     * @param roleId
     * @return
     */
    @RequestMapping("/ascribedRole")
    @ResponseBody
    @RequiresPermissions("grant:role")
    public JSONObject ascribedRole(String userId, String roleId) {
        //判断非空
        if (null == userId || "".equals(userId)) {
            return JsonUtil.packageJson(true, "", "操作失败");
        }
        if (null == roleId || "".equals(roleId)) {
            return JsonUtil.packageJson(true, "", "操作失败");
        }

        //赋予角色
        try {
            roleService.doAscribedRole(userId, roleId);
        } catch (Exception e) {
            logger.error(RoleController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(true, "", "赋予角色失败");
        }
        return JsonUtil.packageJson(true, "赋予成功", "");
    }

    /**
     * 取消用户的角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    @RequestMapping("/cancelRole")
    @ResponseBody
    @RequiresPermissions("grant:role")
    public JSONObject cancelRole(String userId, String roleId) {
        //判断非空
        if (null == roleId || "".equals(roleId)) {
            return JsonUtil.packageJson(true, "", "角色为空");
        }
        if (null == userId || "".equals(userId)) {
            return JsonUtil.packageJson(true, "", "用户名为空");
        }

        //取消角色
        try {
            roleService.doCancelRole(userId, roleId);
        } catch (Exception e) {
            logger.error(RoleController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(true, "", "取消角色失败");
        }
        return JsonUtil.packageJson(true, "取消成功", "");

    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteRole")
    @ResponseBody
    @RequiresPermissions("delete:role")
    public JSONObject deleteRole(String id) {
        //判断非空
        if (null == id || "".equals(id)) {
            return JsonUtil.packageJson(true, "", "id为空");
        }

        //删除角色
        int countDelete = 0;
        try {
            countDelete = roleService.delete(id);
        } catch (Exception e) {
            logger.error(RoleController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(true, "", "删除角色失败");
        }
        boolean deleteSuccess = (0 != countDelete);
        return JsonUtil.packageJson(deleteSuccess, "删除角色成功",
                "该角色还有权限或者还有用户拥有该角色，删除失败");
    }

}
