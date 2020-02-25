package com.cwfkm.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogonObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2477664439101969078L;
	private Integer id=null;
	private String username;
	private String password;
	private String salt;
	private String mobile;
	private String email;
	private Integer valid=1;
	private Date createdTime = new Date();
	private Date modifiedTime = new Date();
	private String createdUser = null;
	private String modifiedUser = null;
	private String headImg;
	private String sex;
	private Integer sumExp = 0;
	private Integer roleId= 0;
	public LogonObject(String username, String password, String email, String headImg, String sex,String  mobile) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.headImg = headImg;
		this.sex = sex;
		this.mobile=mobile;
	}
}
