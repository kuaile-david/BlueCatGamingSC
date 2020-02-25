package com.cwfkm.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
	private Integer id;
	private String username;
	private String operation;
	private String method;
	private String params;
	private long time;
	private String ip;
	private Date createdTime;
}
