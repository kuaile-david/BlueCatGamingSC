package com.cwfkm.pojo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Posty {
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
	private Integer valid=1;
	public Posty(Integer userid, Integer boardid, String title, String content, String username,
			 String istop) {
		super();
		this.id = null;
		this.userId = userid;
		this.boardId = boardid;
		this.title = title;
		this.content = content;
		this.userName = username;
		this.isQuality = null;
		this.isTop = null;
		Date time = new Date();
		this.createdTime = time;
		this.modifiedTime = time;
		this.lastReplyName = userName;
		this.lastReplyTime = time;
		this.hotPoint = 0;
	}
	public Posty(Integer id, Integer userId, Integer boardId, String title, String content, String userName,
			String isQuality, String isTop, Date createdTime, Date modifiedTime, String lastReplyName,
			Date lastReplyTime, Integer hotPoint, Integer valid) {
		super();
		this.id = id;
		this.userId = userId;
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.userName = userName;
		this.isQuality = isQuality;
		this.isTop = isTop;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.lastReplyName = lastReplyName;
		this.lastReplyTime = lastReplyTime;
		this.hotPoint = hotPoint;
		this.valid = valid;
	}
	
	
}
