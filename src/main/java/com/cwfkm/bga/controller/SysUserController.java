package com.cwfkm.bga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bga.common.vo.PageObject;
import com.bga.pojo.LogonObject;
import com.bga.pojo.User;
import com.bga.service.SysUserService;
import com.bga.web.util.JsonResult;
@Controller
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
//	@Autowired
//	private ShiroService shiroService;

	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin( String username, String password) {
//		Subject subject = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//		subject.login(token);
		return new JsonResult("login ok");
	}
	
	@RequestMapping("doFindAllUser")
	@ResponseBody
	public JsonResult doFindAllUser(Integer pageCurrent) {
		PageObject<User> vo = sysUserService.findAllUser(pageCurrent);
		System.out.println(vo);
		return new JsonResult(vo);
	}
	@RequestMapping("doFindPostyList")
	@ResponseBody
	public JsonResult doFindPostyList(Integer pageCurrent) {
		return null;
//		return new JsonResult(sysUserService.findMyPostyById(ShiroUtil.getLoginUser().getId(), pageCurrent));
	}


	@RequestMapping("user_list")
	public String doUpdateUser() {
		return "sys/user_list";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects() {
//		String username = shiroService.getUsernameInSubject();
		Integer id = sysUserService.findIdByName("admin");
		User user = sysUserService.findUserById(id);
		return new JsonResult(user);
	}

	@RequestMapping("doUpdatePassword")
	@ResponseBody
	public JsonResult doUpdatePassword(
			String pwd,
			String newPwd,
			String cfgPwd) {
		System.out.println(pwd+"?"+newPwd+"?"+cfgPwd);
		sysUserService.updatePassword(pwd, newPwd, cfgPwd);
		return new JsonResult("修改成功！");
	}

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
			String username, 
			String password, 
			String email, 
			String sex,
			String mobile) {
		LogonObject logonObject = new LogonObject(username, password, email, "headImage", sex, mobile);
		System.out.println(logonObject);
		sysUserService.saveObject(logonObject);
		return new JsonResult("注册成功！");
	}


	@RequestMapping("isExists")
	@ResponseBody
	public JsonResult isExists(String columnName,String columnValue) {
		return new JsonResult(sysUserService.isExists(columnName, columnValue));
	}
	
	
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id,Integer valid){
//			sysUserService.validById(id, valid,shiroService.getUsernameInSubject()); 
			return new JsonResult("update ok");
	}
}
