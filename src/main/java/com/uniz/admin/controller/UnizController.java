package com.uniz.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uniz.admin.domain.Uniz;
import com.uniz.admin.domain.UnizLayer;
import com.uniz.admin.service.UnizService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class UnizController {

	private UnizService unizService;

	@GetMapping("/admin/uniz/uniz")
	public String uniz() {

		return "admin/uniz";
	}
	
	@GetMapping("/admin/uniz/unizLayer")
	public String unizLayer() {

		return "admin/unizLayer";
	}

	
	@GetMapping("/admin/uniz/unizlist") 
	public @ResponseBody Map<String, Object> unizList() {
	
	List<Uniz> unizList = unizService.unizList2();
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("data",unizList);
	System.out.println("DEBUG - data(get): " +map);
	return map; 
	
	}
	
	@GetMapping("/admin/uniz/unizLayerlist") 
	public @ResponseBody Map<String, Object> unizLayerList() {

	List<UnizLayer> unizLayerList = unizService.unizLayerList();
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("data",unizLayerList);
	System.out.println("DEBUG - data(get): " +map);
	return map; 
	
	}
	
	@GetMapping("/admin/uniz/unizNotLayerlist")
	public @ResponseBody Map<String, Object> unizNotLayerList() {
	

	List<Uniz> unizNotList = unizService.unizNotLayerList();
	
	System.out.println(unizNotList);
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("data",unizNotList);

	return map; 
	
	}
	
	 
	@PostMapping("/admin/uniz/unizinsert")
	public @ResponseBody Map<String, Object> codeInsert(Uniz uniz) {

		System.out.println("insert");
		String result = unizService.unizInsert(uniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Insert data(post) : " +map);
		return map;
	}
	
	@PostMapping("/admin/uniz/unizupdate")
	public @ResponseBody Map<String, Object> codeUpdate(Uniz uniz) {
		
		String result = unizService.unizUpdate(uniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		System.out.println("DEBUG - Update data(post) : " +map);
		
		return map;
	}
	@PostMapping("/admin/uniz/unizdelete")
	public @ResponseBody Map<String, Object> codeDelete(Uniz uniz) {
		
		String result = unizService.unizDelete(uniz);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		System.out.println("DEBUG - Delete data(post) : " +map);
		
		return map;
	}
	
	
	@PostMapping("/admin/uniz/unizLayerinsert")
	public @ResponseBody Map<String, Object> unizLayerInsert(UnizLayer unizLayer) {

		System.out.println("insert");
		String result = unizService.unizLayerInsert(unizLayer);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		System.out.println("DEBUG - Insert data(post) : " +map);
		return map;
	}
	
	@PostMapping("/admin/uniz/unizLayerupdate")
	public @ResponseBody Map<String, Object> unizLayerUpdate(UnizLayer unizLayer) {
		
		String result = unizService.unizLayerUpdate(unizLayer);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		System.out.println("DEBUG - Update data(post) : " +map);
		
		return map;
	}
	@PostMapping("/admin/uniz/unizLayerdelete")
	public @ResponseBody Map<String, Object> unizLayerDelete(UnizLayer unizLayer) {
		
		String result = unizService.unizLayerDelete(unizLayer);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		System.out.println("DEBUG - Delete data(post) : " +map);
		
		return map;
	}
	
}
