package com.uniz.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uniz.admin.domain.ApplyCreatorVO;
import com.uniz.admin.domain.Member;
import com.uniz.admin.domain.MyUnizPoint;

public interface MemberMapper {

	public List<Member> getMemberList();

	public Member getMember(Long userSN);

	public int memberUpdate(Member member);

	public int selectMember(Member member);

	public List<MyUnizPoint> getUserUnizPoint(Long userSN);

	public int changeUserState(@Param("userSN")Long userSN, @Param("state")int state);

	public int userStateLogInsert(@Param("userSN")Long userSN,@Param("state")int state);

	public List<ApplyCreatorVO> getCreatorMemberList();

	public ApplyCreatorVO getCreatorMember(@Param("applySN") Long applySN);

	public void applyCreator(ApplyCreatorVO creator);

	public void changeUserType(@Param("userSN")Long userSN, @Param("userType")int userType);

}
