package com.bga.service;


import com.bga.common.vo.PageObject;
import com.bga.common.vo.SysReplyPageObject;

public interface SysReplyService {
		
	PageObject<SysReplyPageObject> findPageObjectByPostyId(Integer postyId,Integer pageCurrent);

	int updateReply(Integer postyId, Integer username, String content);

}
