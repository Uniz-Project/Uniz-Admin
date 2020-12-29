package com.uniz.admin.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.uniz.admin.domain.Member;
import com.uniz.admin.domain.UnizChartVO;
import com.uniz.admin.service.MainService;
import com.uniz.admin.service.SampleService;
import com.uniz.admin.utils.Util;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class MainController {
	
	private SampleService service;
	private MainService mainService;
	@GetMapping("/admin/main")
	public String main(HttpSession session, Model model) {
		
		Member member = (Member)session.getAttribute("ADMIN");
		
		return member == null ? "/admin/loginForm" : "/admin/main";
	}
	
	@GetMapping("admin/main/newUserCnt")
	public @ResponseBody Map<String, Object> mainnewUserCnt() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int cnt = mainService.newUserCnt(Util.getToday());
		
		map.put("cnt", cnt);
		
		log.info("cnt : " +cnt); 
		return map;
	}
	
	@GetMapping("admin/main/boardWriteCnt")
	public @ResponseBody Map<String, Object> mainboardWriteCnt() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int cnt = mainService.todayBoardWriteCnt(Util.getToday());
		
		map.put("cnt", cnt);
		
		log.info("cnt : " +cnt); 
		return map;
	}
	
	@GetMapping("admin/main/channelCreateCnt")
	public @ResponseBody Map<String, Object> channelCreateCnt() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int cnt = mainService.todayChannelCreateCnt(Util.getToday());
		
		map.put("cnt", cnt);
		
		log.info("cnt : " +cnt); 
		return map;
	}
	
	@GetMapping("admin/main/regVideoCnt")
	public @ResponseBody Map<String, Object> regVideoCnt() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int cnt = mainService.todayRegVideoCnt(Util.getToday());
		
		map.put("cnt", cnt);
		
		log.info("cnt : " +cnt); 
		return map;
	}
	
	@GetMapping("/admin/main/dailyMemberAmount")
	public @ResponseBody Map<String, Object> dailyMemberAmount(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<HashMap<Object, Object>> list = mainService.dailyMemberAmount();
		
		map.put("data", list);
		
		return map;
	}
	
	@GetMapping("/admin/main/dailyChannelAmount")
	public @ResponseBody Map<String, Object> dailyChannelAmount(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<HashMap<Object, Object>> list = mainService.dailyChannelAmount();
		
		map.put("data", list);
		
		return map;
	}
	
	@GetMapping(value="/admin/main/pieChart", produces="text/plain;charset=UTF-8")
	public @ResponseBody String pieChart(){
		Gson gson = new Gson();
		
		List<UnizChartVO> pieList = mainService.pieChartData();
		
		return gson.toJson(pieList);
	}
}
