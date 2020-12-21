package com.uniz.admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniz.admin.domain.Member;
import com.uniz.admin.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class HomeController {
	
	private MemberService memberService; 
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		
		Member member = (Member)session.getAttribute("ADMIN");
		
		 
		return member == null ? "/admin/loginForm" : "/admin/main";
		
	}
	
	@PostMapping("/admin/loginForm")
	public String login(Member member, Model model, HttpSession session) {
		
		final int SUCCESS = 1;
		// 데이터 제대로 들어오는것 확인
		log.info("member :" + member);
		
		int loginResult = memberService.adminLogin(member, session);

		log.info("session Check : " + session.getAttribute("ADMIN"));
		
		return loginResult == SUCCESS ? "/admin/main" : "/admin/loginForm";
	}
	@GetMapping("/admin/admin/logout")
	public String logout(HttpSession session,HttpServletResponse response) throws IOException {
		session.invalidate();
		
		return "redirect:http://localhost:9090/";
	}
	
}
