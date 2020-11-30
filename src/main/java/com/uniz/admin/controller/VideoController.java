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
public class VideoController {
	
	private VideoService videoService;
	
	@GetMapping("/admin/video")
	public String viewVideoList() {
		
		return "admin/videoList";
	}
	
	@GetMapping("/admin/video/list")
	public @ResponseBody Map<String, Object> videoList(){
		List<Video> videoList = videoService.videoList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", videoList);
		System.out.println("DEBUG - data(get): " +map);
		return map; 
	}
	
	@GetMapping("/admin/video/registerForm")
	public String showVideoRegister() {
		
		return "admin/videoRegister";
	}
	
	@PostMapping("/admin/video/registerForm")
	public @ResponseBody Map<String, Object> VideoRegister(Video video) {
		System.out.println("----video"+video);
		String result = videoService.register(video);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Insert data(post) : " +map);
		return map;
	}
	
	@GetMapping("/admin/video/registerForm/{videoSn}")
	public String VideoReigsterWithVideoSn(@PathVariable int videoSn, Model model){
	
		Video Video = videoService.getVideo(videoSn);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", Video);
		System.out.println("DEBUG - data(get): " +map);
		
		model.addAttribute("video",Video);
		
		return "admin/videoRegister"; 
	}
	
}
