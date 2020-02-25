package com.bga.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysBoardMenu implements Serializable{
	private Integer id;
	private String name;
	private Integer topId;
}
