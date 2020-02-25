package com.cwfkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/manage/")
public class SysLogPageController {
	@RequestMapping("user_list")                                  
	public String doLogList() {
		return "sys/log_list";
	}
}
