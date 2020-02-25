package com.cwfkm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysBoardMes {
	private Integer id;
	private String name;
	private Integer topId;
	private String sign;
}
