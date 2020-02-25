package com.cwfkm.common.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysReply implements Serializable{
	private static final long serialVersionUID = 5033423429532886436L;
	private Integer id;
	private Integer postyId;
	private Integer userId;
	private String context;
	private Date createdTime;
	private Integer boardId;
	private String valid;
}
