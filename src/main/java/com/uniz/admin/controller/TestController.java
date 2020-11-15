package com.uniz.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniz.admin.domain.Video;
import com.uniz.admin.service.VideoService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TestController {
	
	private VideoService videoService;
	
	@GetMapping("/admin/test")
	public String showVideoList() {
		
		return "admin/test";
	}
	
	@GetMapping("/admin/test/list")
	public @ResponseBody Map<String, Object> videoList(){
		List<Video> videoList = videoService.videoList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", videoList);
		System.out.println("DEBUG - data(get): " +map);
		return map; 
	}
	
	
	

}
