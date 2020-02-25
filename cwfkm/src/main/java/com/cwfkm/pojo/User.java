package com.cwfkm.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/** 用户个人信息 */
@Data
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7950821509677174451L;
	private Integer id;
	private String username;
	private String email;
	private String sex;
	private String mobile;
	private Integer exp;
	private Integer sumExp;
	private Integer level;
	private String percent;
	private String password;
	private String salt;//盐值
	private Integer valid=1;
	private Integer deptId;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
}
