package com.cwfkm.bga.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bga.common.vo.SysPostyPageVo;
import com.bga.pojo.SysBoardMenu;
import com.bga.service.SysUserService;
import com.cwfkm.bga.service.BoardFeignService;
import com.cwfkm.bga.service.PostyFeignService;
import com.cwfkm.bga.service.ReplyFeignService;

@Controller
@RequestMapping("/web-service")
public class PageController {
	@Autowired
	private BoardFeignService sysBordService;
	@Autowired
	private PostyFeignService sysPostyService;
	@Autowired
	private SysUserService sysUserService;
//	@Autowired
//	private ShiroService shiroService;
	@Autowired
	ReplyFeignService sysReplyService;
	
	
	
	@RequestMapping("/")
	public String dostaterUI(Model model) {
		model.addAttribute("username", "username");
//		model.addAttribute("username", shiroService.getUsernameInSubject());
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
		model.addAttribute("guangGao", sysPostyService.findPageByHot(0, 4));
		model.addAttribute("hots", sysPostyService.findPageByHot(4, 9));
		model.addAttribute("cards", sysPostyService.findPageByHot(13,4));
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
		Map<String,List<SysBoardMenu>> map = new HashMap<String,List<SysBoardMenu>>();
		List<SysBoardMenu> tops = sysBordService.getTops();
		for(SysBoardMenu s:tops) {
			List<SysBoardMenu> Child = sysBordService.getChilds(s.getId());
			map.put(s.getName(), Child);
		}
		model.addAttribute("map", map);
		return "sys/board_map";
	}
}
