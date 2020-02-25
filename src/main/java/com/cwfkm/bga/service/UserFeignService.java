package com.cwfkm.bga.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bga.common.vo.SysPostyPageVo;

@FeignClient(name = "user-service")
public interface UserFeignService {

	@RequestMapping("/findUserById/{userId}")
	SysPostyPageVo findUserById(@PathVariable Integer userId);

}
