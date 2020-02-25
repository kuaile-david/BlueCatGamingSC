package com.cwfkm.bga.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bga.web.util.JsonResult;
import com.cwfkm.bga.service.PostyFeignService;

@Controller
@RequestMapping("/posty/")
public class SysPostyController {
	@Autowired
	private PostyFeignService sysPostyService;


	@RequestMapping("doInsertPosty")
	@ResponseBody
	public JsonResult doPostPosty(String title,Integer boardId,String content) {
		if(""==title||""==content)
			return JsonResult.ok(2);
//		sysPostyService.updatePosty(title,boardId,content);
		return JsonResult.ok("发布成功！！");
	}
	@RequestMapping("doPostPosty")
	public String doPostPosty() {
		return "post_posty";
	}
	@RequestMapping("doPostSave")
	@ResponseBody  
	public JsonResult doPostSave(@RequestParam("img") MultipartFile img) throws IOException {
		BufferedOutputStream out = null;
		byte[] bytes = img.getBytes();  
		String filename = img.getOriginalFilename();
		String localImg = "src/main/resources/static/upLoadImg/"+filename;
		System.out.println("请求保存文件:"+localImg);
		File file = new File(localImg);
		if(!file.exists())
			file.createNewFile();
		else
		{
			file.delete();
			file.createNewFile();
		}
		out = new BufferedOutputStream(new FileOutputStream(file)); 
		out.write(bytes);    
		out.close();
		return JsonResult.ok(filename);
	}
}
