package com.cwfkm.service;

import com.cwfkm.common.vo.PageObject;
import com.cwfkm.pojo.SysLog;

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
