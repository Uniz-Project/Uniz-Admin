package com.uniz.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniz.admin.domain.Uniz;
import com.uniz.admin.service.UnizService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CodeController {

	private UnizService unizService;

	@GetMapping("/admin/code")
	public String code() {

		return "admin/code";
	}

	
	@GetMapping("/admin/code/list") 
	public @ResponseBody Map<String, Object> codeList() {
	
	List<Uniz> unizList = unizService.unizList2();
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("data",unizList);
	System.out.println("DEBUG - data(get): " +map);
	return map; 
	
	}
	 
	@PostMapping("/admin/code/insert")
	public @ResponseBody Map<String, Object> codeInsert(Uniz uniz) {

		
		String result = unizService.unizInsert(uniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Insert data(post) : " +map);
		return map;
	}
	
	@PostMapping("/admin/code/update")
	public @ResponseBody Map<String, Object> codeUpdate(Uniz uniz) {
		
		String result = unizService.unizUpdate(uniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		System.out.println("DEBUG - Update data(post) : " +map);
		
		return map;
	}
	@PostMapping("/admin/code/delete")
	public @ResponseBody Map<String, Object> codeDelete(Uniz uniz) {
		
		String result = unizService.unizDelete(uniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		System.out.println("DEBUG - Delete data(post) : " +map);
		
		return map;
	}
}
