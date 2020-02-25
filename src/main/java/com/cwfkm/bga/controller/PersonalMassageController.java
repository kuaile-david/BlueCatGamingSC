package com.cwfkm.bga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bga.pojo.User;
import com.bga.service.SysUserService;
import com.bga.web.util.JsonResult;
@Controller
@RequestMapping("/person/")
public class PersonalMassageController {
	@Autowired
	private SysUserService sysUserService;
	
	/** 跳转至个人发帖列表 */
	@RequestMapping("posty_list")
	public String doFindPostyById() {
		return "sys/posty_list";
	}
	
	/** 根据跳转至个人信息页面 */
	@RequestMapping("person_list")
	public String doFindMsgById() {
		return "sys/person_list";
	}
	/**
	 * 	更改个人信息
	 * @return
	 */
	@RequestMapping("doUpdateMsg")
	@ResponseBody
	public JsonResult doUpdateMsg(
			User user) {
		sysUserService.updatePersonMsg(user);
		return JsonResult.ok("update ok");
	}
	/**
	 * 	跳转至用户修改密码界面
	 * @return
	 */
	@RequestMapping("password_update")
	public String doUpdatePwdById() {
		return "sys/password_update";
	}
	
}
