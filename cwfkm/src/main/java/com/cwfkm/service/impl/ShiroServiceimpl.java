package com.cwfkm.service.impl;

import org.springframework.stereotype.Service;

import com.cwfkm.common.utils.ShiroUtil;
import com.cwfkm.service.ShiroService;
@Service
public class ShiroServiceimpl implements ShiroService {
	@Override
	public String getUsernameInSubject() {
		String s = "";
		try {
			s=ShiroUtil.getUsername();
		} catch (NullPointerException e) {
			System.out.println("目前没有用户登录");
			return "";
		}
		return s;
	}
}
