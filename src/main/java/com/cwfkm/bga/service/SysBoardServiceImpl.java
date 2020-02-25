package com.cwfkm.bga.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bga.common.exception.ServiceException;
import com.bga.common.vo.PageObject;
import com.bga.pojo.SysBoardMenu;
import com.bga.pojo.SysBoardMes;
import com.bga.pojo.SysPostyItemVo;
import com.bga.service.SysBoardService;
import com.cwfkm.bga.dao.SysBoardDao;

@Service
public class SysBoardServiceImpl implements SysBoardService {

	@Autowired
	SysBoardDao BoardDaoService;
	@Autowired
	PostyFeignService sostyDaoService;

	public List<SysBoardMenu> getTops() {
		return BoardDaoService.findTopMenus();
	}
	
	public List<SysBoardMenu> getChilds(Integer id){
		return BoardDaoService.findChildMenus(id);
	}
	
	@Override
	public Map<String,List<SysBoardMenu>> getBoardMenuList() {
		Map<String,List<SysBoardMenu>> map = new HashMap<String,List<SysBoardMenu>>();
		List<SysBoardMenu> tops = BoardDaoService.findTopMenus();
		for(SysBoardMenu s:tops) {
			List<SysBoardMenu> Child = BoardDaoService.findChildMenus(s.getId());
			map.put(s.getName(), Child);
		}
		return map;
	}

	@Override
	public SysBoardMes getboardMod(Integer id) {
		return BoardDaoService.selectObjectsById(id);
	}


	public PageObject<SysPostyItemVo> findPostyObjects(Integer id, Integer pageCurrent,Integer pageSize) {

		if(pageCurrent==null || pageCurrent<1) {
			throw new ServiceException("页码不正确");
		}
		int rowCount = BoardDaoService.getRowCounts(id); //传入的板块id
		if(rowCount==0) {
			throw new ServiceException("记录不存在");
		}
		int pageIndex = (pageCurrent-1)*pageSize;
		System.out.println(pageIndex);
		List<SysPostyItemVo> records = BoardDaoService.findPageObject(id, pageIndex, pageSize);

		return new PageObject<SysPostyItemVo>(records, rowCount, pageCurrent, pageSize);
	}

	@Override
	public List<SysPostyItemVo> findPostyByHot(Integer pageIndex, Integer pageSize) {
		return sostyDaoService.findPageByHot( pageIndex, pageSize);
	}
}
