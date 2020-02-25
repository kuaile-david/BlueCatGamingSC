package com.cwfkm.common.vo;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/** 主题展示信息对象 */
@Data
public class SysPostyPageVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9183243067051492014L;
	
	private Integer id;
	private String username;
	private Integer postyNum;
	private Integer replyNum;
	private String postyTitle;
	private String postyContent;
	/**
	 * 新增 操作时间 经验值
	 * 作者:温文滔
	 */
	private Date createdTime;
	private Date modifiedTime;
	//经验值
	private Integer exp;
	private String valid;
	
	
	public SysPostyPageVo(Integer id, String username, Integer postyNum, Integer replyNum, String postyTitle,
			String postyContent, Date createdTime, Date modifiedTime, Integer exp,String valid) {
		super();
		this.id = id;
		this.username = username;
		this.postyNum = postyNum;
		this.replyNum = replyNum;
		this.postyTitle = postyTitle;
		this.postyContent = postyContent;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.exp = exp;
		this.valid = valid;
	}
	
	
}
