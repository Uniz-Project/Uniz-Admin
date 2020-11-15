package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.Member;
import com.uniz.admin.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public List<Member> getMemberList() {
		
		log.info("MemberList : " + mapper.getMemberList());
		
		return mapper.getMemberList();
	}

	@Override
	public List<Board> getBoardList(Long userSN) {
		
		log.info("boardList  : " + mapper.getBoardList(userSN));
		
		return mapper.getBoardList(userSN);
	}

	@Override
	public Member getMember(Long userSN) {
		
		return mapper.getMember(userSN);
	}

	@Override
	public String memberUpdate(Member member) {
		
		int check = memberCheck(member);
		
		String resultStr = "";

		if (check >= 1) {
			try {
				int resultCnt = mapper.memberUpdate(member);

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
	
	public int memberCheck(Member member) {
		
		return mapper.selectMember(member);
	}

}
