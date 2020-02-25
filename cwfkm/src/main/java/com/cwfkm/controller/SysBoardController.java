package com.cwfkm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cwfkm.pojo.SysBoardMenuVo;
import com.cwfkm.service.SysBoardService;
import com.cwfkm.service.SysPostyService;

@Controller
@RequestMapping("/board")
public class SysBoardController {
	@Autowired
	SysBoardService sysBoardService;
	@Autowired
	SysPostyService sysPostyService;
	
	@RequestMapping("doGetContent")
	public String doGetContent(Integer boardId){
		return "forward:board/board_mod?"+boardId;
	}
	@RequestMapping("doCreatePosty")
	public String doCreatePosty(Model model,Integer boardId,String boardName){
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardName", boardName);
		return "board/board_form";
	}
	@RequestMapping("doBoardMenu")
	public String doBoardMap(Model model){
		model.addAttribute("map", sysBoardService.getBoardMenuList().getDataMap());
		return "board/board_map";
	}
	
	
	@RequestMapping("doBoardUI")
	public String doBoardUI(Model model,Integer id,Integer pageCurrent){
		model.addAttribute("mod", sysBoardService.getboardMod(id));
		model.addAttribute("postys", sysBoardService.findPostyObjects(id, pageCurrent,7));
		return "board/board_mod";
	}
	
	
	@RequestMapping("doSearch")
	public String doSearch(Model model,String like,Integer pageCurrent) {
		model.addAttribute("like", like);//搜索字段
		model.addAttribute("postys", sysPostyService.findPostyObjectsByName(like, pageCurrent,7));//搜索结果
		return "board/board_search";
	}
	
	
}
