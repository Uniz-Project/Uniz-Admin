package com.uniz.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.ReportVO;
 
public interface BoardMapper {

	public List<Board> getBoardList();

	public int boardDelete(Long postSN);

	public int selectBoard(Long postSN);

	public Board getBoard(Long postSN);

	public List<Board> getMemberBoardList(Long userSN);

	public List<Board> getBoardTitle();

	public List<Board> getTitleBoardList(@Param("boardSN")Long boardSN);

	public int updateBoardPost(Board board);

	public int updateBoardContent(Board board);

	public List<ReportVO> getReportList();

	public ReportVO getReportBoard(@Param("reportSN")Long reportSN);

	public void applyReport(@Param("reportSN")Long reportSN, @Param("state_n")int state);

	public void deleteBoardReply(@Param("postSN")Long postSN);

	public void deleteBoardContent(@Param("postSN")Long postSN);
	
	//public int boardUpdate(Long postSN);
	
}
