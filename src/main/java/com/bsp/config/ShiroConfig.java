package com.bsp.config;

/*import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;*/
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
	
	/*
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean sfb = new ShiroFilterFactoryBean();
		sfb.setSecurityManager(securityManager);
		sfb.setLoginUrl("login");
		sfb.setSuccessUrl("index");
		sfb.setUnauthorizedUrl("unauthorized");
		Map<String, FormAuthenticationFilter> filters = new HashMap<String, FormAuthenticationFilter>();
		filters.put("authc", value)
		sfb.setFilterChainDefinitions("");
		return null; 
	}*/
	
}
