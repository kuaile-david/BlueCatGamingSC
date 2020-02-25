package com.cwfkm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cwfkm.common.vo.SysPostyPageVo;
import com.cwfkm.service.ShiroService;
import com.cwfkm.service.SysBoardService;
import com.cwfkm.service.SysPostyService;
import com.cwfkm.service.SysReplyService;
import com.cwfkm.service.SysUserService;

@Controller
@RequestMapping("/")
public class PageController {
	@Autowired
	private SysBoardService sysBordService;
	@Autowired
	private SysPostyService sysPostyService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private ShiroService shiroService;
	@Autowired
	SysReplyService sysReplyService;
	
	@RequestMapping("/")
	public String dostaterUI(Model model) {
		model.addAttribute("username", shiroService.getUsernameInSubject());
		return "starter";
	}
	@RequestMapping("logon")
	public String dologonUI() {
		return "logon";
	}
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	@RequestMapping("log/{moduleUI}")
	public String doLogList(@PathVariable String moduleUI) {
		return "log"+moduleUI;
	}
	@RequestMapping("sys/{moduleUI}")
	public String doSysList(@PathVariable String moduleUI) {
		return "sys/"+moduleUI;
	}
	@RequestMapping("role/{moduleUI}")
	public String doRoleList(@PathVariable String moduleUI) {
		return "role/"+moduleUI;
	}
	@RequestMapping("doSysIndex")
	public String doSysUI() {
		return "sys/sysIndex";
	}
	@RequestMapping("doIndex")
	public String doIndexUI(Model model) {
		model.addAttribute("guangGao", sysBordService.findPostyByHot(0, 4));
		model.addAttribute("hots", sysBordService.findPostyByHot(4, 9));
		model.addAttribute("cards", sysBordService.findPostyByHot(13,4));
		return "index";
	}
	@RequestMapping("doPostyUI")
	public String doPostyIndex(Model model,Integer id) {
		//帖子内容
		SysPostyPageVo pageObject = sysPostyService.findPageObjectById(id);
		model.addAttribute("postyid", id);
		model.addAttribute("pageObject", pageObject);
		//发帖人信息
		model.addAttribute("userID",sysUserService.findIdByName(pageObject .getUsername()));
		return "posty_index";
	}
	@RequestMapping("sys/doBoardMenu")
	public String doBoardMap(Model model){
		model.addAttribute("map", sysBordService.getBoardMenuList().getDataMap());
		return "sys/board_map";
	}
}
