package com.uniz.admin.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	private int userSN; //유저번호
	private String userID; //아이디
	private String password; //비밀번호
	private String provider; //소셜가입처
	private int userType; //유저타입
	private String nick; //닉네임
	private String imgUrl; //프로필사진
	private int state; //회원상태
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date lastLoginDatetime; //최종로그인시간

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date createDatetime; //가입일시
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date updateDatetime; //변경일시
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date lastStateDatetime; //최종회원상태변경시간
	
	private ApplyCreatorVO creatorVO;
	
}
