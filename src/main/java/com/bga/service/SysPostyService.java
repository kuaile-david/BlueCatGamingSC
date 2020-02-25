package com.bga.service;

import java.util.List;

import com.bga.common.vo.PageObject;
import com.bga.common.vo.SysPostyPageVo;
import com.bga.pojo.Posty;

public interface SysPostyService {
	PageObject<Posty> findPostyObjectsByName(String like, Integer pageCurrent,Integer pageSize);
	SysPostyPageVo findPageObjectById(Integer postyId);
	List<Posty> findReplyByPostyId(Integer postyId);
	int updatePosty(String title,Integer boardId,String content);
}
