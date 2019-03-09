package com.dayi.demo.shiro.realm;

import com.dayi.demo.user.model.Premission;
import com.dayi.demo.user.model.Role;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.PremissionService;
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
 * @Author wut
 * @Date 2019-03-05
 */
public class LoginRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PremissionService premissionService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String email = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        User user = userService.getUserByEmail(email);
        List<Role> roles = roleService.findRoleByUserId(user.getId());
        LinkedHashSet<String> premissions = new LinkedHashSet<String>();
        for(Role role : roles) {
            info.addRole(role.getRoleName());
            List<Premission> rolePremissions = premissionService.findByRoleId(role.getId());
            for(Premission premission : rolePremissions) {
                premissions.add(premission.getField());
            }
        }
        info.addStringPermissions(premissions);

        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String email = token.getPrincipal().toString();
        User user = userService.getUserByEmail(email);
        if(null == user) {
            throw new AccountException();
        }
        String principals = user.getEmail();
        String credentials = user.getPassword();
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getId());
        String realmName = getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principals, credentials, credentialsSalt, realmName);
        return info;
    }


}
