package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.Board;

public interface BoardService {

	public List<Board> getBoardList();

	public String boardDelete(Long postSN);

	public Board getBoard(Long postSN);

}
