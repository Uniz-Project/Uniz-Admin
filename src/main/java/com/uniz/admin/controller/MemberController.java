package com.uniz.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.Member;
import com.uniz.admin.domain.Video;
import com.uniz.admin.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class MemberController {
	
	private MemberService memberService;
	
	@GetMapping("/admin/member")
	public String main() {
		
		return "admin/memberList";
	}
		
	@GetMapping("/admin/member/list")
	public @ResponseBody Map<String, Object> memberList(){
		List<Member> memberList = memberService.getMemberList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", memberList);
		log.info("memberList .... : " + memberList);
		return map; 
	}
	
	//유저의 게시물확인
	@GetMapping("/admin/member/board/{userSN}")
	public @ResponseBody Map<String, Object> memberBoardList(@PathVariable Long userSN){
		
		List<Board> memberBoardList = memberService.getBoardList(userSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", memberBoardList);
		log.info("memberList .... : " + memberBoardList);
		
		return map; 
	}
	@GetMapping("/admin/member/update/{userSN}")
	public String memberUpdate(@PathVariable Long userSN, Model model){
		
		Member member = memberService.getMember(userSN);
		
		log.info("member .... : " + member);
		
		model.addAttribute("member",member);
		
		return "/admin/memberUpdate"; 
	}
	@PostMapping("/admin/member/update")
	public @ResponseBody Map<String, Object> memberUpdate(Member member) {
		
		log.info("member .... : " + member);
		String result = memberService.memberUpdate(member);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		log.info("memberUpdate ..... :"+map);
		return map;
	}

}
