package com.cwfkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cwfkm.common.vo.SysReply;
import com.cwfkm.pojo.Reply;

@Mapper
public interface SysReplyDao {
	
	
	/** 根据用户Id获取全部回复	  */
	@Select("select * from sys_reply where user_id = #{userId}")
	List<SysReply> findAllByUserId(Integer userId);
	
	
	/** 根据主题id获取全部回复	 */
	@Select("select * from (select * from sys_reply where posty_id=#{postyId} order by created_time desc) p limit #{pageIndex},#{pageSize}")
	List<SysReply> findPageObjectByPostyId(@Param("postyId")Integer postyId,
										@Param("pageIndex")Integer pageIndex,
										@Param("pageSize")Integer pageSize);
	
	
	/** 根据主题id 查询回复总数 */
	@Select("select count(*) from sys_reply where posty_id = #{id}")
	int getRowCounts(Integer id);


	int updateObject(Reply reply);
	
}
