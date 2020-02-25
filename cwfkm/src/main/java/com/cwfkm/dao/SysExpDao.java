package com.cwfkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cwfkm.pojo.ExpLevel;
@Mapper
public interface SysExpDao {
	
	/**经验值
	 * @return
	 */
	@Select("select * from exp_level")
	List<ExpLevel> findObjectByExp();
	@Select("select * from exp_level where sum_exp < #{exp} order by level desc limit 0,1")
	ExpLevel findObjectBylimit(Integer exp);
}
