package com.uniz.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/admin/member")
	public String main() {
		
		return "admin/member";
	}
}
