package com.uniz.admin.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniz.admin.domain.ApplyCreatorVO;
import com.uniz.admin.domain.EmailVO;
import com.uniz.admin.domain.Member;
import com.uniz.admin.domain.MyUnizPoint;
import com.uniz.admin.mapper.MemberMapper;
import com.uniz.admin.utils.EmailSender;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	private BCryptPasswordEncoder PasswordEncode;
	private EmailSender emailSender;

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

	@Override
	public List<ApplyCreatorVO> getCreatorMemberList() {
		
		return mapper.getCreatorMemberList();
	}

	@Override
	public ApplyCreatorVO getCreatorMember(Long applySN) {
		
		return mapper.getCreatorMember(applySN);
	}
	
	//일반회원 - > 크리에이터 승인
	
	@Override
	@Transactional
	public String applyCreator(ApplyCreatorVO creator,int state) {
		final int USERTYPE = 2;
		
		String SUCCESS = "SUCCESS";
		String FAIL = "FAIL";
		
		if(creator != null) {
			try {
				//1. applycreator 테이블의 상태를 변경한다.
				creator.setState(state);
				mapper.applyCreator(creator);
				
				//2. 유저타입을 2로 변경한다.
				if(state == 2) {
					mapper.changeUserType(creator.getUserSN(), USERTYPE);
					//3. 이메일을 전송한다.
					String userEmail = creator.getEmail();
//					String test = "eodbs4747@naver.com";
					
					EmailVO email = new EmailVO();
					
					email.setReceiver(userEmail);
					  email.setContent("<strong>저희 Uniz를 이용 해주셔서 감사합니다.</strong>" + "<br><br><br>" + 
					  "크리에이터 등록이 되셨으므로 채널 게시판을 만드실 수 있으십니다.");
					  email.setSubject("Uniz 크리에이터 신청 관련 이메일입니다");
					  
					  emailSender.SendEmail(email);
					
				}
				
				return SUCCESS;
			}catch(Exception e){
				e.printStackTrace();
				return FAIL;
			}
			
		}
		return FAIL;
		
				
	}

	@Override
	public int adminLogin(Member member, HttpSession session) {
		final int SUCCESS = 1;
		final int NO_DUPLICATION = 0;
		final int FAIL = -1;
		
		//아이디, 비밀번호 유효성 체크
		if(isVaildUser(member) == true) {
			//아이디랑 비밀번호가 DB의 값과 일치하는지 확인한다.
			String password= member.getPassword();
			String dbPassword = mapper.getUserPassword(member);
			Boolean pwdMatch = PasswordEncode.matches(password, dbPassword);
			//로그인 성공
			if(pwdMatch) {	
				//세션 생성
				member = mapper.getUser(member);
				session.setAttribute("ADMIN", member);
				session.setAttribute("userType", member.getUserType());
				
				//로그인 이력 변경
				mapper.updateUserLogin(member.getUserSN());
				return SUCCESS;
			}
		}
		return FAIL;
	}
	
	public boolean isVaildUser(Member dto) {
		return dto.getUserID() != null &&  dto.getPassword() != null ? true : false;
	}

	@Override
	public List<ApplyCreatorVO> getCreatorMemberList(Long applySN) {
		
		return mapper.getCreatorMemberFileList(applySN);
	}

}
