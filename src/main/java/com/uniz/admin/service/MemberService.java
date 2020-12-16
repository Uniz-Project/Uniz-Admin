package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.Member;
import com.uniz.admin.domain.MyUnizPoint;

public interface MemberService {

	public List<Member> getMemberList();

	public Member getMember(Long userSN);

	public String memberUpdate(Member member);

	public List<MyUnizPoint> getUserUnizPoint(Long userSN);

	public String changeUserState(Long userSN, int sTATECODE);
	
}
