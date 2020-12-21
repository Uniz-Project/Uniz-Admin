package com.uniz.admin.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uniz.admin.domain.Member;
import com.uniz.admin.service.SampleService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	
	private SampleService service;
	
	@GetMapping("/admin/main")
	public String main(HttpSession session, Model model) {
		
		Member member = (Member)session.getAttribute("ADMIN");
		
		 
		return member == null ? "/admin/loginForm" : "/admin/main";
		
	}
}
