package com.fanlu.staffmanage.utils;

import com.fanlu.staffmanage.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by YGwhere on 2021/2/8 21:09
 * Description: staffmanage
 *
 * @Author 15011_
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if(principalCollection == null) {
            throw new AuthenticationException();
        }
        String account = (String) getAvailablePrincipal(principalCollection);
        int auth = loginService.checkUserAuth(account);
        Set<String> roles = new HashSet<>();
        switch (auth) {
            case Constant.AUTH_INC :
                roles.add(Constant.STRING_INC);
                roles.add(Constant.STRING_PERSON);
                break;
            case Constant.AUTH_PERSON:
                roles.add(Constant.STRING_PERSON);
                break;
            case Constant.AUTH_MANAGER:
                roles.add(Constant.STRING_INC);
                roles.add(Constant.STRING_PERSON);
                roles.add(Constant.STRING_MANAGER);
                break;
            default:
                break;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = token.getUsername();
        if (!loginService.checkIsAccount(account)) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(account, loginService.checkUser(account), getName());
    }
}
