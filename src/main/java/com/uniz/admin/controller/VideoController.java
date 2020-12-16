package com.uniz.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniz.admin.domain.DataTableDTO;
import com.uniz.admin.domain.Video;
import com.uniz.admin.service.VideoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
public class VideoController {
	
	private VideoService videoService;
	
	@GetMapping("/admin/video")
	public String viewVideoList() {
		
		return "admin/videoList";
	}
	
	@PostMapping("/admin/video/list")
	public @ResponseBody DataTableDTO videoList(DataTableDTO dto, @RequestBody MultiValueMap<String, String> formData){
		int draw = Integer.parseInt(formData.get("draw").get(0));
		int start = Integer.parseInt(formData.get("start").get(0));
		int length = Integer.parseInt(formData.get("length").get(0));				
		
		log.info("draw : " + draw);
		log.info("start : " + start);
		log.info("length : " + length);
		                      
		dto = videoService.videoList(dto,draw,start,length);
		
		log.info("dto" + dto);
		return dto;
		
//		List<Video> videoList = videoService.videoList();
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("data", videoList);
//		System.out.println("DEBUG - data(get): " +map);
//		return map; 
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
	
	@PostMapping("/admin/video/delete/{videoSN}")
	public @ResponseBody Map<String, Object> videoDelete(@PathVariable Long videoSN) {
		
		String result = videoService.videoDelete(videoSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Insert data(post) : " +map);
		return map;
	}
	
	@PostMapping("/admin/video/update/{videoSN}")
	public @ResponseBody Map<String, Object> videoUpdate(Video video) {
		
		String result = videoService.videoUpdate(video);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Insert data(post) : " +map);
		return map;
	}
	
}
