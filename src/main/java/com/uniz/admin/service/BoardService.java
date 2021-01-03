package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.ReportVO;

public interface BoardService {

	public List<Board> getBoardList();

	public String boardDelete(Long postSN);

	public Board getBoard(Long postSN);

	public List<Board> getMemberBoardList(Long userSN);

	public List<Board> getBoardTitle();

	public List<Board> getTitleBoardList(Long boardSN);

	public void updateBoard(Board board);

	public List<ReportVO> getReportBoardList();

	public ReportVO getReportBoard(Long reportSN);

	public String applyReport(ReportVO reportVO, int state);
	
	public int cascadeDeleteBoardPost(Long postSN);
}
