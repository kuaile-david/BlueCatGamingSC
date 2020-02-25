package com.cwfkm.common.utils;

import org.apache.shiro.SecurityUtils;

import com.cwfkm.pojo.User;

public class ShiroUtil {

	public static String getUsername() {
		return getLoginUser().getUsername();
	}
	/**
	 * 获取登录用户
	 * @return
	 */
	public static User getLoginUser() {
		return (User)SecurityUtils.getSubject().getPrincipal();
	}
}
