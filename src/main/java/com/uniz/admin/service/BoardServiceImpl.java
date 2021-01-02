package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.ReportVO;
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
	//게시물 삭제
	public String boardDelete(Long postSN) {
		
		//삭제하려는 게시물이 존재하는지 확인ww
		int check = boardCheck(postSN);
		String resultStr = "";
		
		//삭제하려는 게시물이 존재하면
		if (check > 0) {
			try {
				//DB에 문제가 있을 수 있으니 예외처리
				//쿼리 실행
				int resultCnt = mapper.boardDelete(postSN);

				if (resultCnt > 0) {
					//제대로 동작했을 경우 "success" 반환
					resultStr = "success";
				} else {
					//문제가 있을 시 "fail"
					resultStr = "fail";
				}
			} catch (Exception e) {
				// DB에 문제가 있을 시 역시 "fail"
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			// 해당 게시물이 존재하지 않을경우 "duplicate"
			resultStr = "duplicate";
		}
		
		//js에서 ajax호출시 반환받은 resultStr값으로 상태에 따른 alert출력.
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

	@Override
	public List<Board> getMemberBoardList(Long userSN) {
		
		log.info("boardList  : " + mapper.getMemberBoardList(userSN));
		
		return mapper.getMemberBoardList(userSN);
	}

	@Override
	public List<Board> getBoardTitle() {
		
		return mapper.getBoardTitle();
	}

	@Override
	public List<Board> getTitleBoardList(Long boardSN) {
		try {						
			 List<Board>boardList =  mapper.getTitleBoardList(boardSN);
			 return boardList;		
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	@Override
	public void updateBoard(Board board) {
	
		log.info("board"+ board);
		int postResult = mapper.updateBoardPost(board);
		int contentResult = mapper.updateBoardContent(board);
		
	}

	@Override
	public List<ReportVO> getReportBoardList() {
		
		return mapper.getReportList();
	}

	@Override
	public ReportVO getReportBoard(Long reportSN) {
		
		return mapper.getReportBoard(reportSN);
	}

	@Override
	public String applyReport(ReportVO reportVO, int state) {
		
		String SUCCESS = "SUCCESS";
		String FAIL = "FAIL";
		
		if(reportVO != null) {
			try {
				
				mapper.applyReport(reportVO.getReportSN(), state);
				
				if(state == 2) {
					//승인 시 게시글도 삭제시켜줘야한다.
					cascadeDeleteBoardPost(reportVO.getPostSN());
				}
				return SUCCESS;
			}catch(Exception e) {
				e.printStackTrace();
				return FAIL;
			}
		}
		return FAIL;
	}
	
	@Transactional
	@Override
	public void cascadeDeleteBoardPost(Long postSN) {
		
		//댓글삭제
		mapper.deleteBoardReply(postSN);
		log.info("댓글삭제완료");
		//본문삭제
		mapper.deleteBoardContent(postSN);
		log.info("본문삭제완료");
		//게시물삭제
		mapper.boardDelete(postSN);
		log.info("게시물삭제완료");
	}
	
	
}
