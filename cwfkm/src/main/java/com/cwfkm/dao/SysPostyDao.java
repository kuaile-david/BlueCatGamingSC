package com.cwfkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cwfkm.common.vo.SysPostyVo;
import com.cwfkm.pojo.Posty;
import com.cwfkm.pojo.SysPostyItemVo;

@Mapper
public interface SysPostyDao {
	@Select("select count(title) from sys_posty where title like concat('%',#{like},'%')"
						+ "limit #{pageIndex},#{pageSize}")
	int countSearchPosty(String like, Integer pageIndex, Integer pageSize);
	@Select("select * from sys_posty where user_id = #{userId}")
	List<SysPostyVo> findAllByUserId(Integer userId);
	
	@Select("select * from sys_posty where id = #{id}")
	SysPostyVo findObjectById(Integer id);

	@Select("select * from sys_posty where title like concat('%','${like}','%')"
			+ "limit #{pageIndex},#{pageSize}")
	List<Posty> findPostyObjectsByName(String like, Integer pageIndex, Integer pageSize);
	@Select("select count(*) from sys_posty where board_id = #{id}")
	int getRowCounts(Integer id);
	
	List<SysPostyItemVo> findPageObject(@Param("id")Integer id,
										@Param("pageIndex")Integer pageIndex,
										@Param("pageSize")Integer pageSize);
	
	List<SysPostyItemVo> findPageByHot(
			@Param("pageIndex")Integer pageIndex,
			@Param("pageSize")Integer pageSize);
	
	List<SysPostyVo> findPostysByUserId(Integer userId,
										Integer pageIndex,
										Integer pageSize);
	
	@Select("select count(*) from sys_posty where user_id = #{userId}")
	int getRowCountsByUserId(Integer userId);
	
	int insertContent(Posty posty);
	
}
