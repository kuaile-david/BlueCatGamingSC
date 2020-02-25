package com.cwfkm.service;

import java.util.List;

import com.cwfkm.common.vo.PageObject;
import com.cwfkm.common.vo.SysPostyPageVo;
import com.cwfkm.pojo.Posty;

public interface SysPostyService {
	PageObject<Posty> findPostyObjectsByName(String like, Integer pageCurrent,Integer pageSize);
	SysPostyPageVo findPageObjectById(Integer postyId);
	List<Posty> findReplyByPostyId(Integer postyId);
	int updatePosty(String title,Integer boardId,String content);
}
