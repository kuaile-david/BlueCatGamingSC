package com.cwfkm.common.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro框架配置类
 */
@Configuration
public class SpringShiroConfig {

	@Bean
	public SecurityManager securityManager(Realm realm) {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		return sManager;
	}
	
	

	/** 配置过滤器工厂(通过此工厂创建大量过滤器，通过过滤器对请求进行过滤) */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(@Autowired SecurityManager securityManager) {
		// 创建过滤器工厂bean
		ShiroFilterFactoryBean fBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		fBean.setSecurityManager(securityManager);
		fBean.setLoginUrl("/doLoginUI");
		// 设置过滤规则
		Map<String, String> fcdMap = new LinkedHashMap<>();
		// 静态资源允许匿名访问:"anon"
		fcdMap.put("/bower_components/**", "anon");
		fcdMap.put("/css/**", "anon");
		fcdMap.put("/build/**", "anon");
		fcdMap.put("/dist/**", "anon");
		fcdMap.put("/image/**", "anon");
		fcdMap.put("/js/**", "anon");
		fcdMap.put("/posty/**", "anon");
		fcdMap.put("/ueditor/**", "anon");
		fcdMap.put("/user/doLoginUI**","anon");
		fcdMap.put("/user/doLogin","anon");
		fcdMap.put("/doLogout", "logout");
		fcdMap.put("/sys/**","anon");
//		fcdMap.put("/user/doLogin", "anon");
//		fcdMap.put("/sys/**","user");
		fcdMap.put("/doSysIndex","user");
		fcdMap.put("/board/doCreatePosty","user");
		

		// 除了匿名访问的资源,其它都要认证("authc")后访问
		// fcdMap.put("/**","authc");
		fBean.setFilterChainDefinitionMap(fcdMap);
		return fBean;

	}
}
