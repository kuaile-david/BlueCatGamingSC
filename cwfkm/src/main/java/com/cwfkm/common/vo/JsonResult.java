package com.cwfkm.common.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 基于此对象封装控制层对象的响应结果
 *  在此对象中应该包含返回到客户端的数据
 * 以及一个状态码和状态信息
 * */
@Getter
@Setter
@NoArgsConstructor
public class JsonResult {
	private int state=1;
	private String message="ok";
	private Object data;
	
	public JsonResult(Object data) {
		this.data = data;
	}
	public JsonResult(String string) {
		this.message = string;
	}
	
}
