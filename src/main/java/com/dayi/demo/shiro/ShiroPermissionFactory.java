package com.dayi.demo.shiro;

import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wut
 * @Date 2019-03-06
 */
public class ShiroPermissionFactory extends ShiroFilterFactoryBean {
    /**
     * xml中的配置
     */
    public static String definitions;


    @Override
    public void setFilterChainDefinitions(String definitions) {
        ShiroPermissionFactory.definitions = definitions;

        Map<String, String> otherChains = new HashMap<String, String>(16);
        otherChains.put("/user/loginPage", "anon");
        otherChains.put("/user/login", "anon");


        /** 从配置文件加载权限配置 */
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }

        //加入权限集合
        section.putAll(otherChains);
        section.put("/**", "authc");
        setFilterChainDefinitionMap(section);
    }

}
