package com.fanlu.staffmanage.config;

import com.fanlu.staffmanage.filter.ShiroFilter;
import com.fanlu.staffmanage.utils.Constant;
import com.fanlu.staffmanage.utils.MyRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
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
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(securityManager);

        Map<String, Filter> filters = new HashMap<>();
        ShiroFilter authenticationFilter = new ShiroFilter();
        filters.put("authc", authenticationFilter);
        filter.setFilters(filters);

        Map<String, String> fiterChainMap = new LinkedHashMap<>();
        fiterChainMap.put("/login", "anon");
        fiterChainMap.put("/noPermission", "anon");
        fiterChainMap.put("/register", "anon");
        fiterChainMap.put("/findpassword", "anon");
        fiterChainMap.put("/","anon");

        fiterChainMap.put("/user/**", "authc,roles[" + Constant.STRING_PERSON + "]");
        fiterChainMap.put("/admin/**", "authc,roles[" + Constant.STRING_INC + "]");
        fiterChainMap.put("/super/**", "authc,roles[" + Constant.STRING_MANAGER + "]");

        fiterChainMap.put("/logout", "logout");

        fiterChainMap.put("/**", "authc");
        filter.setFilterChainDefinitionMap(fiterChainMap);

        return filter;
    }
}
