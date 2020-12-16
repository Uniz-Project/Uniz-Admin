package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.Member;
import com.uniz.admin.domain.MyUnizPoint;
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
	
	//회원의 유니즈포인트 조회
	@Override
	public List<MyUnizPoint> getUserUnizPoint(Long userSN) {
		
		return mapper.getUserUnizPoint(userSN);
	}

	@Override
	public String changeUserState(Long userSN, int state) {
		String SUCCESS = "SUCCESS";
		String FAIL = "FAIL";
		
		if(userSN != null) {
			try {
				//회원상태를 3으로 변경해야한다.
				mapper.changeUserState(userSN, state);
				//userstateLog 테이블에도 데이터를 추가해 줘야한다.
				mapper.userStateLogInsert(userSN, state);
				
				return SUCCESS;
			}catch(Exception e){
				e.printStackTrace();
				return FAIL;
			}
			
		}
		return FAIL;
	}

}
