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
	//Update임시..
	public String memberUpdate(Member member) {
		
		//Update전 해당 회원이 존재하는지 조회
		//review - 메서드이름 정확히, 어떤멤버체크인지 
		String resultStr = "";
		
		//해당 회원이 존재하면 실행
		if (memberIsValidCheck(member)) {
			try {
				//회원정보를 관리자페이지에서 수정해도 되는지몰라서 일단 적용하지않았음 o
				//DB에 문제가 있을 수 있으니 예외처리
				int resultCnt = mapper.memberUpdate(member);
				
				if (resultCnt > 0) {
					//제대로 동작했을 경우 "success" 반환
					//반환타입 상수로 enum
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
			//해당 회원이 존재하지 않으면 "duplicate"
			resultStr = "duplicate";
		}
		
		//js에서 ajax호출시 반환받은 resultStr값으로 상태에 따른 alert출력.
		return resultStr;
	}
	
	@Override
	//DB에서 회원리스트를 가져오는 메서드
	public List<Member> getMemberList() {
		
		log.info("MemberList : " + mapper.getMemberList());
		
		return mapper.getMemberList();
	}

	@Override
	public Member getMember(Long userSN) {
		
		return mapper.getMember(userSN);
	}
	
	//회원을 조회하는 메서드 
	public boolean memberIsValidCheck(Member member) {	
		
		int chkValid = mapper.selectMember(member);
		
		return chkValid >= 1 ? true : false;  
	}

}
