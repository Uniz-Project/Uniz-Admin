package com.uniz.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uniz.admin.domain.Board;
 
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

	//public int boardUpdate(Long postSN);
	
}
