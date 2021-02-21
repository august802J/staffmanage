package com.fanlu.staffmanage.config;

import com.fanlu.staffmanage.utils.Constant;
import com.fanlu.staffmanage.utils.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by YGwhere on 2021/2/21 13:24
 * Description: staffmanage
 *
 * @Author 15011_
 */
@Configuration
public class ShiroConfig {

    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityDefaultWebSecurityManagerManager(Realm myRealm) {
        DefaultWebSecurityManager defaultSecurityManager  = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(myRealm);
        return defaultSecurityManager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();

        Map<String, String> fiterChainMap = new LinkedHashMap<>();
        fiterChainMap.put("/login", "anon");

        fiterChainMap.put("/user/**", "authc,roles[" + Constant.STRING_PERSON + "]");
        fiterChainMap.put("/admin/**", "authc,roles[" + Constant.STRING_INC + "]");
        fiterChainMap.put("/super/**", "authc,roles[" + Constant.STRING_MANAGER + "]");

//        fiterChainMap.put("/**", "authc");
        definition.addPathDefinitions(fiterChainMap);
        return definition;
    }
}
