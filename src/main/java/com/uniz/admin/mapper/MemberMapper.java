package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.Board;
import com.uniz.admin.domain.Member;

public interface MemberMapper {

	public List<Member> getMemberList();

	public Member getMember(Long userSN);

	public int memberUpdate(Member member);

	public int selectMember(Member member);

}
