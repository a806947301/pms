package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.model.Role;
import com.dayi.demo.user.service.RoleService;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("/role")
public class RoleController {

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
        int coundAdd = roleService.addRole(role);
        boolean addSuccess = (0 != coundAdd);
        return JsonUtil.packageJson(addSuccess, "", "添加角色失败");
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
        int countUpdate = roleService.updateRole(role);
        boolean updateSuccess = (0 != countUpdate);
        return JsonUtil.packageJson(updateSuccess, "", "更新角色失败");
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
        int countAdd = roleService.doAscribedRole(userId, roleId);
        boolean addSuccess = (0 != countAdd);
        return JsonUtil.packageJson(addSuccess, "", "赋予角色失败");
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
        int countDelete = roleService.doCancelRole(userId, roleId);
        boolean deleteSuccess = (0 != countDelete);
        return JsonUtil.packageJson(deleteSuccess, "", "取消角色失败");

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
        int countDelete = roleService.deleteRole(id);
        boolean deleteSuccess = (0 != countDelete);
        return JsonUtil.packageJson(deleteSuccess, "删除角色成功",
                "该角色还有权限或者还有用户拥有该角色，删除失败");
    }

}
