package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.Board;

public interface BoardMapper {

	public List<Board> getBoardList();

	public int boardDelete(Long postSN);

	public int selectBoard(Long postSN);

	public Board getBoard(Long postSN);

	//public int boardUpdate(Long postSN);
	
}
