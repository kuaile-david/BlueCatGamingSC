package com.cwfkm.common.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysMyPostyVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2361413480542198448L;
	private Integer postyId;
	private String title;
	private Date createdTime;
	private Integer boardId;
	private String valid;
	private Integer replyNum;
	public SysMyPostyVo(Integer postyId, String title, Date createdTime, Integer boardId, String valid,
			Integer replyNum) {
		super();
		this.postyId = postyId;
		this.title = title;
		this.createdTime = createdTime;
		this.boardId = boardId;
		this.valid = valid;
		this.replyNum = replyNum;
	}
	
}
