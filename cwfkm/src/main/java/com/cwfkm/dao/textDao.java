package com.cwfkm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface textDao {
	
	@Insert("insert into text (text) values(#{text})")
	int insertText();
}
