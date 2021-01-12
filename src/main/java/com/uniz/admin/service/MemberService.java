package com.uniz.admin.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.uniz.admin.domain.ApplyCreatorVO;
import com.uniz.admin.domain.Member;
import com.uniz.admin.domain.MyUnizPoint;

public interface MemberService {

	public List<Member> getMemberList();

	public Member getMember(Long userSN);

	public String memberUpdate(Member member);

	public List<MyUnizPoint> getUserUnizPoint(Long userSN);

	public String changeUserState(Long userSN, int sTATECODE);

	public List<ApplyCreatorVO> getCreatorMemberList();

	public ApplyCreatorVO getCreatorMember(Long applySN);

	public String applyCreator(ApplyCreatorVO creator, int state);

	public int adminLogin(Member member, HttpSession session);

	public List<ApplyCreatorVO> getCreatorMemberList(Long applySN);
	
}
