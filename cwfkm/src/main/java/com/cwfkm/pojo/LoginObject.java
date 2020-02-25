package com.cwfkm.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * 登录信息对象
 */
@Data
public class LoginObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4580486675654558638L;
	private String username;
	private String password;
	private boolean isRememberMe;
	public LoginObject(String username, String password, boolean isRememberMe) {
		super();
		this.username = username;
		this.password = password;
		this.isRememberMe = isRememberMe;
	}
}
