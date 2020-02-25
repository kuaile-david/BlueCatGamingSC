package com.cwfkm.common.vo;


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
	private String content;
	private String title;
	private Integer userId;
	private String UserName;
	private Integer boardId;
	private String isQuality;
	private String isTop;
	private Date createdTime;
	private Date modifiedTime;
	private Date lastReplyTime;
	private String lastReplyName;
	private String hotPoint;
	private String valid;
}
