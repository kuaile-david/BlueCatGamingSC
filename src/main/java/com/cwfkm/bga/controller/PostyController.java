package com.cwfkm.bga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bga.common.vo.PageObject;
import com.bga.common.vo.SysPostyPageVo;
import com.bga.common.vo.SysPostyVo;
import com.bga.pojo.Posty;
import com.bga.pojo.SysPostyItemVo;
import com.bga.service.SysPostyService;
import com.cwfkm.bga.dao.SysPostyDao;

@RestController("posty-service")
public class PostyController {
	
	@Autowired
	SysPostyDao sysPostydao;
	@Autowired
	SysPostyService sysPostyService;
	
	@RequestMapping("/findPageByHot/{pageIndex}/{pageSize}")
	List<SysPostyItemVo> findPageByHot(@PathVariable Integer pageIndex, @PathVariable Integer pageSize){
		return sysPostydao.findPageByHot(pageIndex, pageSize);
	}
	
	@RequestMapping("/findPostyObjectsByName/{like}/{pageCurrent}/{pageSize}")
	PageObject<Posty> findPostyObjectsByName(@PathVariable String like,
			@PathVariable Integer pageCurrent,@PathVariable Integer pageSize) {
		return sysPostyService.findPostyObjectsByName(like, pageCurrent, pageSize);
	}
	
	@RequestMapping("/findPostysByUserId/{userId}/{pageIndex}/{pageSize}")
	List<SysPostyVo> findPostysByUserId(@PathVariable Integer userId,
			@PathVariable Integer pageIndex,@PathVariable Integer pageSize) {
		return sysPostydao.findPostysByUserId(userId, pageIndex, pageSize);
	}

	@RequestMapping("/getRowCountsByUserId/{userId}")
	Integer getRowCountsByUserId(@PathVariable Integer userId) {
		return sysPostydao.getRowCountsByUserId(userId);
	}
	
	@RequestMapping("/findPageObjectById/{id}")
	SysPostyPageVo findPageObjectById(@PathVariable Integer id) {
		return sysPostyService.findPageObjectById(id);
	}
}
