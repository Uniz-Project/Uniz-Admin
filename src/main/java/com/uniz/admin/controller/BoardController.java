package com.uniz.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.ReportVO;
import com.uniz.admin.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class BoardController {
	
	private BoardService boardService;
	
	//게시물 관리 페이지
	@GetMapping("/admin/board")
	public String viewBoardList(Model model) {
//		List<String> titleList = new ArrayList<>();
		
		List<Board> titleList = boardService.getBoardTitle();
		
		log.info("titleList : " + titleList );
		model.addAttribute("titleList", titleList);
		return "admin/boardList";
	}
	
	//게시물 관리 페이지 - ajax로 리스트 데이트 전달	
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
	

	@PostMapping("/admin/board/update")
	public String boardUpdatePost(Board board) {
		
		boardService.updateBoard(board);
		
		
		return "redirect:/admin/board";
	}
	
	
	@GetMapping("/admin/board/detail/{postSN}")
	public String boardDetail(@PathVariable Long postSN, Model model) {
		
		log.info("postSN ....:"+postSN);
		
		List<Board> board = boardService.getBoardListWithFile(postSN);
//		Board board = boardService.getBoard(postSN);
		
		log.info("board ...." + board);
		
		model.addAttribute("board",board); 
		
		return "/admin/boardDetail";
	}
	
	@GetMapping("/admin/board/boardTitle/{boardSN}")
	public @ResponseBody Map<String, Object> boardTitle(@PathVariable Long boardSN) {
		
		List<Board> boardList = boardService.getTitleBoardList(boardSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", boardList);
		return map; 
		
	}
	
	@GetMapping("/admin/board/boardReportList")
	public @ResponseBody Map<String, Object> boardReportList(){
		List<ReportVO> reportList = boardService.getReportBoardList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", reportList);
		return map; 
	}
	
	@PostMapping("/admin/board/report/accept/{reportSN}/{state}")
	public @ResponseBody Map<String, Object> acceptReport(@PathVariable Long reportSN,@PathVariable int state){
		
		ReportVO report = boardService.getReportBoard(reportSN);
		
		log.info("reportVO : " + report);
		
		String result = boardService.applyReport(report,state);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		return map;
	}
}
