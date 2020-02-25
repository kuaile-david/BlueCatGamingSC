package com.cwfkm.bga.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bga.common.vo.SysReply;

@FeignClient(name = "reply-service",fallback = ReplyFeignServiceFallBack.class)
public interface ReplyFeignService {

	@RequestMapping("findAllByUserId/{userId}")
	List<SysReply> findAllByUserId(@PathVariable Integer userId);

}
