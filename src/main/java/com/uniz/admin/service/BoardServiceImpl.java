package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.Board;
import com.uniz.admin.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public List<Board> getBoardList() {
		
		return mapper.getBoardList();
	}

	@Override
	public String boardDelete(Long postSN) {
		
		int check = boardCheck(postSN);
		String resultStr = "";

		if (check > 0) {
			try {
				int resultCnt = mapper.boardDelete(postSN);

				if (resultCnt > 0) {
					resultStr = "success";
				} else {
					resultStr = "fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			resultStr = "duplicate";
		}

		return resultStr;
	}

	public int boardCheck(Long postSN) {
		return mapper.selectBoard(postSN);
	}

	@Override
	public Board getBoard(Long postSN) {
		
		log.info(mapper.getBoard(postSN));
		
		return mapper.getBoard(postSN);
	}
}
