package com.dayi.demo.common.shiro.realm;

import com.dayi.demo.user.model.Permission;
import com.dayi.demo.user.model.Role;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.PermissionService;
import com.dayi.demo.user.service.RoleService;
import com.dayi.demo.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 登陆、授权Realm
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-05
 */
public class AuthRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户邮箱
        String email = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前用户
        User user = userService.getByEmail(email);
        //查找当前用户拥有角色
        List<Role> roles = roleService.findRoleByUserId(user.getId());
        LinkedHashSet<String> permissions = new LinkedHashSet<String>();
        //遍历每个角色，并把当前角色拥有的权限增加到permissions
        for (Role role : roles) {
            info.addRole(role.getRoleName());
            List<Permission> rolePermissions = permissionService.findByRoleId(role.getId());
            for (Permission permission : rolePermissions) {
                //把权限字段添加到permissions
                permissions.add(permission.getField());
            }
        }
        //添加权限到info
        info.addStringPermissions(permissions);

        return info;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取登陆邮箱
        String email = token.getPrincipal().toString();
        //从数据库获取邮箱对应用户
        User user = userService.getByEmail(email);
        if (null == user) {
            throw new AccountException();
        }

        //设置认证信息
        String principals = user.getEmail();
        String credentials = user.getPassword();
        //获取盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getId());
        String realmName = getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principals, credentials,
                credentialsSalt, realmName);
        return info;
    }


}
