package com.uniz.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uniz.admin.service.SampleService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	
	private SampleService service;
	
	@GetMapping("/admin/main")
	public String main(Model model) {
		
		System.out.println(service.getTime());
		
		return "admin/main";
	}
}
