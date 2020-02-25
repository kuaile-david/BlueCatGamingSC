package com.bga.common.vo;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 *	posty数据库对象
 */
@Data
public class SysPostyVo implements Serializable{
	private static final long serialVersionUID = 4236417780081809944L;
	private Integer id;
	private Integer userId;
	private Integer boardId;
	private String  title;
	private String content;
	private String  userName;
	private String  isQuality;
	private String  isTop;
	private Date  createdTime;
	private Date  modifiedTime;
	private String  lastReplyName;
	private Date  lastReplyTime;
	private Integer hotPoint;
	private String valid;
}
