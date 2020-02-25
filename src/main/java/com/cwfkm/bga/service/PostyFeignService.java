package com.cwfkm.bga.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bga.common.vo.PageObject;
import com.bga.common.vo.SysPostyPageVo;
import com.bga.common.vo.SysPostyVo;
import com.bga.pojo.Posty;
import com.bga.pojo.SysPostyItemVo;
import com.bga.web.util.JsonResult;

@FeignClient(name = "posty-service", fallback = PostyFeignServiceFB.class)
public interface PostyFeignService {

	@RequestMapping("/findPageByHot/{pageIndex}/{pageSize}")
	List<SysPostyItemVo> findPageByHot(@PathVariable Integer pageIndex, @PathVariable Integer pageSize);

	@RequestMapping("/findPageObjectById/{id}")
	SysPostyPageVo findPageObjectById(@PathVariable Integer id);

	@RequestMapping("/findPostyObjectsByName/{like}/{pageCurrent}/{pageSize}")
	PageObject<Posty> findPostyObjectsByName(@PathVariable String like,
			@PathVariable Integer pageCurrent, @PathVariable Integer pageSize);

	@RequestMapping("/findPostysByUserId/{userId}/{pageIndex}/{pageSize}")
	List<SysPostyVo> findPostysByUserId(@PathVariable Integer userId,
			@PathVariable Integer pageIndex, @PathVariable Integer pageSize);

	@RequestMapping("/getRowCountsByUserId/{userId}")
	Integer getRowCountsByUserId(@PathVariable Integer userId);
}
