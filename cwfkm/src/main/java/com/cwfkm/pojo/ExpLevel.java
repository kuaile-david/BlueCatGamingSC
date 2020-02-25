package com.cwfkm.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExpLevel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6528671900368585172L;
	private Integer level;
	private Integer exp;
	private Integer sumExp;
	public ExpLevel(Integer level, Integer exp, Integer sumExp) {
		super();
		this.level = level;
		this.exp = exp;
		this.sumExp = sumExp;
	}
}
