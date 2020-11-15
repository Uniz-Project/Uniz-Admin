package com.uniz.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {
	@GetMapping("/admin/video")
	
	public String main() {
		
		return "index";
	}
}
