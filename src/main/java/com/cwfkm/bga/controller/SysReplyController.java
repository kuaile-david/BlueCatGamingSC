package com.cwfkm.bga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bga.common.vo.PageObject;
import com.bga.common.vo.SysReplyPageObject;
import com.bga.service.SysReplyService;
import com.bga.service.SysUserService;
import com.bga.web.util.JsonResult;


@Controller
@RequestMapping("/reply/")
public class SysReplyController {
	
	@Autowired
	SysReplyService sysReplyService;
//	@Autowired
//	ShiroService shiroService;
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("doReplyUI")
	@ResponseBody
	public JsonResult doReplyUI(Integer postId,Integer pageCurrent) {
		//回复
		System.out.println("$$$...kaishi");
		PageObject<SysReplyPageObject> result 
			= sysReplyService.findPageObjectByPostyId(postId, pageCurrent);
		System.out.println("$$$"+result.getRecords().toString());
		return new JsonResult(result);
	}
	@RequestMapping("doInsertReply")
	@ResponseBody
	public JsonResult doInsertReply(Integer postyid,String content) {
//		String userName = shiroService.getUsernameInSubject();
//		if(userName=="")
//			return new JsonResult(0);
		int rows = sysReplyService.updateReply(postyid,sysUserService.findIdByName("admin"),content);
		return new JsonResult(rows);
	}
}
