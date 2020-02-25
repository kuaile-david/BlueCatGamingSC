package com.cwfkm.pojo;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysBoardMenuVo {
	Map<String,List<SysBoardMenu>> dataMap;
}
