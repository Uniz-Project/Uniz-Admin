package com.uniz.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniz.admin.domain.Wniz;
import com.uniz.admin.service.WnizService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class WnizController {
	
	private WnizService wnizService; 
	
	@GetMapping("/admin/wniz")
	public String wniz() {
		
		return "admin/wniz";
	}
	
	@GetMapping("/admin/wniz/wnizlist")
	public @ResponseBody Map<String,Object> wnizList(){
		
		List<Wniz> wnizList = wnizService.wnizList();
		
		System.out.println("위니즈리스트 " + wnizList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", wnizList);
		
		
		
		System.out.println("DEBUG - WnizList :  " +map);
		return map; 
		
	}
	
	@PostMapping("/admin/wniz/wnizinsert")
	public @ResponseBody Map<String, Object> codeInsert(Wniz wniz) {

		String result = wnizService.wnizInsert(wniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Insert data(post) : " +map);
		return map;
	}
	
	@PostMapping("/admin/wniz/wnizupdate")
	public @ResponseBody Map<String, Object> codeUpdate(Wniz wniz) {

		
		String result = wnizService.wnizUpdate(wniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Update data(post) : " +map);
		return map;
	}
	
	@PostMapping("/admin/wniz/wnizdelete")
	
	public @ResponseBody Map<String, Object> codedelete(Wniz wniz) {


		String result = wnizService.wnizDelete(wniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Delete data(post) : " +map);
		return map;
	}
	
}
