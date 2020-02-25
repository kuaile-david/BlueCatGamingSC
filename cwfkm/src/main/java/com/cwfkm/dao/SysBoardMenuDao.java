package com.cwfkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cwfkm.pojo.SysBoardMenu;
import com.cwfkm.pojo.SysBoardMes;
import com.cwfkm.pojo.SysPostyItemVo;

@Mapper
public interface SysBoardMenuDao extends BaseDao{
	
	
	@Select("select id,name,top_id topId from sys_board ")
	List<SysBoardMenu> findAllObjects();
	
	@Select("select id,name,top_id topId from sys_board where top_id=#{id}")
	List<SysBoardMenu> findChildMenus(Integer id);
	
	@Select("select id,name,top_id topId from sys_board where top_id is null")
	List<SysBoardMenu> findTopMenus();
	
	@Select("select id,name,top_id topId from sys_board where id=#{id}")
	SysBoardMes selectObjectsById(Integer id);
	
	@Select("select count(*) from sys_posty where board_id = #{id}")
	int getRowCounts(Integer id);
	
	List<SysPostyItemVo> findPageObject(@Param("id")Integer id,
										@Param("pageIndex")Integer pageIndex,
										@Param("pageSize")Integer pageSize);
	
}
