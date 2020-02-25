package com.cwfkm.bga.service;

import java.util.List;

import com.bga.common.vo.PageObject;
import com.bga.common.vo.SysPostyPageVo;
import com.bga.common.vo.SysPostyVo;
import com.bga.pojo.Posty;
import com.bga.pojo.SysPostyItemVo;

public class PostyFeignServiceFB implements PostyFeignService{

	@Override
	public List<SysPostyItemVo> findPageByHot(Integer pageIndex, Integer pageSize) {
		return null;
	}

	@Override
	public SysPostyPageVo findPageObjectById(Integer id) {
		return null;
	}

	@Override
	public PageObject<Posty> findPostyObjectsByName(String like, Integer pageCurrent, Integer pageSize) {
		return null;
	}

	@Override
	public List<SysPostyVo> findPostysByUserId(Integer userId, Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRowCountsByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
