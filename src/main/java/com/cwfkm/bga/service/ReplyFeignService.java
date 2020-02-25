package com.cwfkm.bga.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "reply-service")
public interface ReplyFeignService {

}
