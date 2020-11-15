package com.uniz.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("/admin/board")
	public String main() {
		
		return "/index";
	}
}
