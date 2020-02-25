package com.bga.service;

import java.util.List;
import java.util.Map;

import com.bga.common.vo.PageObject;
import com.bga.pojo.SysBoardMenu;
import com.bga.pojo.SysBoardMes;
import com.bga.pojo.SysPostyItemVo;

public interface SysBoardService {
	Map<String, List<SysBoardMenu>> getBoardMenuList();
	SysBoardMes getboardMod(Integer id);
	
	List<SysPostyItemVo> findPostyByHot(Integer pageCurrent,Integer pageSize);
	PageObject<SysPostyItemVo> findPostyObjects(Integer id,Integer pageCurrent,Integer pageSize);
	
	List<SysBoardMenu> getTops();
	
	List<SysBoardMenu> getChilds(Integer id);
	
}
