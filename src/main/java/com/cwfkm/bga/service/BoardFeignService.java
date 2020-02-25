package com.cwfkm.bga.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bga.common.vo.PageObject;
import com.bga.pojo.SysBoardMenu;
import com.bga.pojo.SysBoardMes;
import com.bga.pojo.SysPostyItemVo;

@FeignClient(name = "board-service")
public interface BoardFeignService {

	@RequestMapping("/findPostyByHot/{pageCurrent}/{pageSize}")
	List<SysPostyItemVo> findPostyByHot(@PathVariable("pageCurrent") Integer pageCurrent,
									@PathVariable("pageSize") Integer pageSize);

	@RequestMapping("/getBoardMenuList/")
	Map<String,List<SysBoardMenu>> getBoardMenuList();

	@RequestMapping("/getboardMod/{id}")
	SysBoardMes getboardMod(@PathVariable Integer id);

	@RequestMapping("/findPostyObjects/{id}/{pageCurrent}/{pageSize}")
	PageObject<SysPostyItemVo> findPostyObjects(@PathVariable Integer id, 
			@PathVariable Integer pageCurrent, @PathVariable Integer pageSize);

	@RequestMapping("/getTops") 
	List<SysBoardMenu> getTops();

	@RequestMapping("/getChilds/{id}")
	List<SysBoardMenu> getChilds(@PathVariable Integer id);

}
