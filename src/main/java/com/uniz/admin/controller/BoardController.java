package com.uniz.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniz.admin.domain.Member;
import com.uniz.admin.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class BoardController {

	//private BoardService boardService;
	
	@GetMapping("/admin/board")
	public String main() {
		
		return "admin/boardList";
	}
		
//	@GetMapping("/admin/board/list")
//	public @ResponseBody Map<String, Object> boardList(){
//		List<> boardList = boardService.getBoardList();
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("data", boardList);
//		log.info("memberList .... : " + boardList);
//		return map; 
//	}
}
