package com.cwfkm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BaseDao {
	
	@Update("update ${tableName} set ${updateRow}=#{updateValue} where ${targetRow}=#{targetValue}")
	int updateObject(String tableName,String targetRow,Object targetValue,String updateRow,Object updateValue);
	List<Map<String,Object>> findPageObjects(
			String table,String param,Object value,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
}
