package com.bga.service;

import com.bga.common.vo.PageObject;
import com.bga.pojo.SysLog;

public interface SysLogService {
	
	int deleteObjects(Integer... ids);
	
	PageObject<SysLog> findPageObjects(String username,
			Integer pageCurrent);
	
	/**
	 * 记录日志
	 * @param entity
	 */
	void saveObject(SysLog entity);

}
