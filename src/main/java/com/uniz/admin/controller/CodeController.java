package com.uniz.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodeController {
	@GetMapping("/admin/code")
	public String main() {
		
		return "admin/code";
	}
}
