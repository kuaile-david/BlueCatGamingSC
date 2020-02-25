package com.cwfkm.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cwfkm.pojo.SysLog;

@Mapper
public interface SysLogDao extends BaseDao{
	/**
	 * 	新增日志
	 * @param sysLog
	 * @return
	 */
	int insertObject(SysLog entity);
	  /**
	   * 基于记录id执行删除业务(有些公司,记录不会
	   * 直接删除,而是在删除时修改其状态)
	   * @param ids
	   * @return rows
	   */
	  int deleteObjects(@Param("ids")Integer...ids);
      
	  /**
	   * 	基于条件查询当前页要呈现的数据
	   * @param username 查询条件
	   * @param startIndex 起始位置
	   * @param pageSize 页面大小(每页最多要显示多少条记录)
	   * @return 当前页对应的日志记录
	   */
	  List<SysLog> findPageObjects(
			 @Param("username") String username); //param3
}
