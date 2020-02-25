package com.cwfkm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysBoardMenu {
	private Integer id;
	private String name;
	private Integer topId;
}
