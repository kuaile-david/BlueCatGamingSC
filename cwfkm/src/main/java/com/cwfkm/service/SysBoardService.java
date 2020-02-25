package com.cwfkm.service;

import java.util.List;

import com.cwfkm.common.vo.PageObject;
import com.cwfkm.pojo.SysBoardMenuVo;
import com.cwfkm.pojo.SysBoardMes;
import com.cwfkm.pojo.SysPostyItemVo;

public interface SysBoardService {
	SysBoardMenuVo getBoardMenuList();
	SysBoardMes getboardMod(Integer id);
	
	List<SysPostyItemVo> findPostyByHot(Integer pageCurrent,Integer pageSize);
	PageObject<SysPostyItemVo> findPostyObjects(Integer id,Integer pageCurrent,Integer pageSize);
	
}
