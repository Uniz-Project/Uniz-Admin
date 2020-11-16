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
import com.uniz.admin.domain.Uniz;
import com.uniz.admin.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;
	
	@GetMapping("/admin/board")
	public String main() {
		
		return "admin/boardList";
	}
		
	@GetMapping("/admin/board/list")
	public @ResponseBody Map<String, Object> boardList(){
		
		List<Board> boardList = boardService.getBoardList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", boardList);
		log.info("boardList .... : " + boardList);
		return map; 
	}
	
	@PostMapping("/admin/board/delete/{postSN}")
	public @ResponseBody Map<String, Object> boardDelete(@PathVariable Long postSN) {
		
		String result = boardService.boardDelete(postSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		log.info("boardDelete"+ result);
		
		return map;
	}
	
	@GetMapping("/admin/board/update/{postSN}")
	public String boardUpdate(@PathVariable Long postSN, Model model){
		
		Board board = boardService.getBoard(postSN);
		
		log.info("board .... : " + board);
		
		model.addAttribute("board",board);
		
		return "/admin/boardUpdate"; 
	}
	
	
	@GetMapping("/admin/board/detail/{postSN}")
	public String boardDetail(@PathVariable Long postSN, Model model) {
		
		log.info("postSN ....:"+postSN);
		
		Board board = boardService.getBoard(postSN);
		
		log.info("board ...." + board);
		
		model.addAttribute("board",board); 
		
		return "/admin/boardDetail";
	}
}
