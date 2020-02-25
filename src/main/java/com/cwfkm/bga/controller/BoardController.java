package com.cwfkm.bga.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bga.common.vo.PageObject;
import com.bga.pojo.SysBoardMenu;
import com.bga.pojo.SysBoardMes;
import com.bga.pojo.SysPostyItemVo;
import com.bga.service.SysBoardService;

@RestController("/")
public class BoardController {
	
	@Autowired
	SysBoardService sysBoardService;
	
	
	@GetMapping("/getBoardMenuList/")
	Map<String,List<SysBoardMenu>> getBoardMenuList() {
		return sysBoardService.getBoardMenuList();
	}
	
	@RequestMapping("/findPostyByHot/{pageCurrent}/{pageSize}")
	List<SysPostyItemVo> findPostyByHot(@PathVariable("pageCurrent") Integer pageCurrent,
													@PathVariable("pageSize") Integer pageSize) {
		System.out.println("pageCurrent: "+pageCurrent+"  pageSize: "+pageSize);
		return sysBoardService.findPostyByHot(pageCurrent,pageSize);
	}

	@RequestMapping("/getboardMod/{id}")
	SysBoardMes getboardMod(@PathVariable Integer id) {
		return sysBoardService.getboardMod(id);
	}

	@RequestMapping("/findPostyObjects/{id}/{pageCurrent}/{pageSize}")
	PageObject<SysPostyItemVo> findPostyObjects(@PathVariable Integer id, 
			@PathVariable Integer pageCurrent, @PathVariable Integer pageSize) {
		return sysBoardService.findPostyObjects(id, pageCurrent, pageSize);
	}
	
	@RequestMapping("/getTops") 
	List<SysBoardMenu> getTops() {
		return sysBoardService.getTops();
	}
	
	@RequestMapping("/getChilds/{id}")
	List<SysBoardMenu> getChilds(@PathVariable Integer id) {
		return sysBoardService.getChilds(id);
	}
}
