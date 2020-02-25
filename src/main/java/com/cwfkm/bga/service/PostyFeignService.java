package com.cwfkm.bga.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bga.pojo.SysPostyItemVo;

@FeignClient(name="posty-service", fallback = PostyFeignServiceFB.class)
public interface PostyFeignService {

	@RequestMapping("/findPageByHot//{pageIndex}/{pageSize}")
	List<SysPostyItemVo> findPageByHot(@PathVariable("pageIndex") Integer pageIndex, @PathVariable("pageSize") Integer pageSize);
}
