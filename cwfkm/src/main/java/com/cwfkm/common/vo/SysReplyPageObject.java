package com.cwfkm.common.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysReplyPageObject implements Serializable{
	
	private static final long serialVersionUID = -8966715298748435598L;
	
	private Integer postyId;
	private Integer boardId;
	private Integer userId;
	private String userName;
	private Integer postyNum;
	private Integer replyNum;
	private String context;
	private Date createdTime;
	private String valid;
	
	
	
	public SysReplyPageObject(Integer postyId, Integer boardId, Integer userId, String userName, Integer postyNum,
			Integer replyNum, String context, Date createdTime, String valid) {
		super();
		this.postyId = postyId;
		this.boardId = boardId;
		this.userId = userId;
		this.userName = userName;
		this.postyNum = postyNum;
		this.replyNum = replyNum;
		this.context = context;
		this.createdTime = createdTime;
		this.valid = valid;
	}
	
	
	
	
}
