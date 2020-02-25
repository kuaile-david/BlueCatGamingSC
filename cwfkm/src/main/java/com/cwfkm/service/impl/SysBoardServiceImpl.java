package com.cwfkm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cwfkm.common.exception.ServiceException;
import com.cwfkm.common.vo.PageObject;
import com.cwfkm.dao.SysBoardMenuDao;
import com.cwfkm.dao.SysPostyDao;
import com.cwfkm.pojo.SysBoardMenu;
import com.cwfkm.pojo.SysBoardMenuVo;
import com.cwfkm.pojo.SysBoardMes;
import com.cwfkm.pojo.SysPostyItemVo;
import com.cwfkm.service.SysBoardService;

@Service
public class SysBoardServiceImpl implements SysBoardService {
	@Autowired
	SysBoardMenuDao sysBoardMenuDao;
	@Autowired
	SysPostyDao sysPostyDao;
	
	@Cacheable(value = "boardCache")
	@Override
	public SysBoardMenuVo getBoardMenuList() {
		Map<String,List<SysBoardMenu>> map = new HashMap<String,List<SysBoardMenu>>();
		List<SysBoardMenu> tops = sysBoardMenuDao.findTopMenus();
		for(SysBoardMenu s:tops) {
			List<SysBoardMenu> Child = sysBoardMenuDao.findChildMenus(s.getId());
			map.put(s.getName(), Child);
		}
		return new SysBoardMenuVo(map);
	}

	@Override
	public SysBoardMes getboardMod(Integer id) {
		return sysBoardMenuDao.selectObjectsById(id);
	}
	

	public PageObject<SysPostyItemVo> findPostyObjects(Integer id, Integer pageCurrent,Integer pageSize) {
		
		if(pageCurrent==null || pageCurrent<1) {
			throw new ServiceException("页码不正确");
		}
		int rowCount = sysBoardMenuDao.getRowCounts(id); //传入的板块id
		if(rowCount==0) {
			throw new ServiceException("记录不存在");
		}
		int pageIndex = (pageCurrent-1)*pageSize;
		System.out.println(pageIndex);
		List<SysPostyItemVo> records = sysBoardMenuDao.findPageObject(id, pageIndex, pageSize);
		
		return new PageObject<SysPostyItemVo>(records, rowCount, pageCurrent, pageSize);
	}

	@Override
	public List<SysPostyItemVo> findPostyByHot(Integer pageIndex, Integer pageSize) {
		return sysPostyDao.findPageByHot( pageIndex, pageSize);
	}
}
