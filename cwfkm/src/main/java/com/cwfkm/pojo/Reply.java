package com.cwfkm.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	private Integer id;
	private Integer postyId;
	private Integer userId;
	private String context;
	private Date createdTime;
	private Integer  boardId;
	private Integer  valid=1;
	public Reply(Integer postyId2,Integer userId,String context) {
		id=null;
		this.postyId=postyId2;
		this.userId = userId;
		this.context = context;
		this.createdTime = new Date();
		this.boardId = null;
	};
}
