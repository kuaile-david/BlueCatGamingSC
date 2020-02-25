package com.cwfkm.service;


import com.cwfkm.common.vo.PageObject;
import com.cwfkm.common.vo.SysReplyPageObject;

public interface SysReplyService {
		
	PageObject<SysReplyPageObject> findPageObjectByPostyId(Integer postyId,Integer pageCurrent);

	int updateReply(Integer postyId, Integer username, String content);

}
