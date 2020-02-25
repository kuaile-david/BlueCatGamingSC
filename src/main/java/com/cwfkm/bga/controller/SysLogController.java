package com.cwfkm.bga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bga.common.vo.PageObject;
import com.bga.pojo.SysLog;
import com.bga.service.SysLogService;
import com.bga.web.util.JsonResult;

//@Controller
//@ResponseBody
@RestController //==@Controller+@ResponseBody
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	
	@RequestMapping("doDeleteObjects")
	public JsonResult doDeleteObjects(Integer...ids) {
		sysLogService.deleteObjects(ids);
		return JsonResult.ok("delete ok");
	}
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String username,Integer pageCurrent) {
		System.out.println(username);
		PageObject<SysLog> pageObject=
		sysLogService.findPageObjects(username,
				pageCurrent);
		System.out.println("pageObject="+pageObject);
		return JsonResult.ok(pageObject);
	}
	/**
	 * @ExceptionHandler 注解描述的方法为一个异常处理方法
	 * @param e
	 * @return
	 */
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseBody
//	public JsonResult doHandleRuntimeException(
//			RuntimeException e) {
//		System.out.println("==local==");
//		e.printStackTrace();
//		return new JsonResult(e);
//	}
}







