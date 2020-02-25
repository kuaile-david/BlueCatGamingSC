package com.cwfkm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cwfkm.common.vo.JsonResult;
import com.cwfkm.common.vo.PageObject;
import com.cwfkm.common.vo.SysReplyPageObject;
import com.cwfkm.service.ShiroService;
import com.cwfkm.service.SysReplyService;
import com.cwfkm.service.SysUserService;


@Controller
@RequestMapping("/reply/")
public class SysReplyController {
	
	@Autowired
	SysReplyService sysReplyService;
	@Autowired
	ShiroService shiroService;
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
		String userName = shiroService.getUsernameInSubject();
		if(userName=="")
			return new JsonResult(0);
		int rows = sysReplyService.updateReply(postyid,sysUserService.findIdByName(userName),content);
		return new JsonResult(rows);
	}
}
