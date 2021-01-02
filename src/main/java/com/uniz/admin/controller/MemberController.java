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

import com.uniz.admin.domain.ApplyCreatorVO;
import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.Member;
import com.uniz.admin.domain.MyUnizPoint;
import com.uniz.admin.service.BoardService;
import com.uniz.admin.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class MemberController {
	
	private MemberService memberService;
	
	private BoardService boardService;
	
	//review - 20201125 viewController
	@GetMapping("/admin/member")
	public String viewMemberList() {
		
		return "admin/memberList";
	}
	
	//js -  memberList() 호출시 ajax요청 
	@GetMapping("/admin/member/list")
	public @ResponseBody Map<String, Object> memberList(){
		List<Member> memberList = memberService.getMemberList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", memberList);
		log.info("memberList .... : " + map);
		return map; //select 결과를 map으로
	}
	
	//유저의 게시물확인
	@GetMapping("/admin/member/board/{userSN}")
	public @ResponseBody Map<String, Object> memberBoardList(@PathVariable Long userSN){
		
		List<Board> memberBoardList = boardService.getMemberBoardList(userSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", memberBoardList);
		log.info("memberList .... : " + memberBoardList);
		
		return map; 
	}
	
	//회원정보수정클릭시 회원정보상세에서 수정하도록
	@GetMapping("/admin/member/detail/{userSN}")
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
	
	//회원정보수정클릭시 회원정보상세에서 수정하도록
	@PostMapping("/admin/member/delete/{userSN}")
	public @ResponseBody Map<String, Object> memberDelete(@PathVariable Long userSN){
		
		log.info(userSN);
		final int STATECODE = 3; //탈퇴상태
		
		String result = memberService.changeUserState(userSN, STATECODE);
			
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
			
		log.info("memberUpdate ..... :"+map);
		return map;			 
	}
	
	@GetMapping("/admin/member/uniz/{userSN}")
	public String memberUniz(@PathVariable Long userSN, Model model){
		
		log.info("userSN : " + userSN);
		
		model.addAttribute("userSN", userSN);
		return "/admin/userUnizPoint"; 
	}
	
	@PostMapping("/admin/member/uniz/{userSN}")
	public @ResponseBody Map<String, Object> memberUnizList(@PathVariable Long userSN) {
		
		log.info("userSN :" + userSN);
		List<MyUnizPoint> userUnizPoint = memberService.getUserUnizPoint(userSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", userUnizPoint);
	
		return map;
	}
	
	@GetMapping("/admin/member/creator")
	public String creator() {
		
		return "/admin/creator";
	}
	
	@PostMapping("/admin/member/creator")
	public @ResponseBody Map<String, Object> creatorList(){
		List<ApplyCreatorVO> CreatorList = memberService.getCreatorMemberList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", CreatorList);
		log.info("memberList .... : " + map);
		return map; //select 결과를 map으로
	}
	
	@PostMapping("/admin/member/creator/accept/{applySN}/{state}")
	public @ResponseBody Map<String, Object> acceptApply(@PathVariable Long applySN,@PathVariable int state){
		log.info("applySN : " + applySN);
		log.info("state : " + state);
		
		ApplyCreatorVO Creator = memberService.getCreatorMember(applySN);
		
		String result = memberService.applyCreator(Creator,state);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map; //결과를 map으로
	}
	
	@GetMapping("/admin/member/creator/detail/{applySN}")
	public String creatorDetail(@PathVariable Long applySN, Model model) {
		
		ApplyCreatorVO Creator = memberService.getCreatorMember(applySN);
		
		model.addAttribute("Creator", Creator);
		
		return "/admin/creatorDetail";
	}
}
