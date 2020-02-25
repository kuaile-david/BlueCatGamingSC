package com.cwfkm.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPostyItemVo {
	private Integer id;
	private String title;//贴子
	private String userName;//作者
	private Date createdTime;//创建时间
	private String lastReplyName;//最近回复人
	private Date lastReplyTime;//最近回复时间
	
}
