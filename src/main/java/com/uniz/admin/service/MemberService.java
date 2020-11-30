package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.Member;

public interface MemberService {

	public List<Member> getMemberList();

	public Member getMember(Long userSN);

	public String memberUpdate(Member member);
	
}
