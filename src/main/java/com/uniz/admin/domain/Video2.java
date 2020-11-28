package com.uniz.admin.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Video2 {
	
	private int videoSn; //비디오번호
	private String title; //제목
	private String authorNick; //게시자 닉네임
	private String description; // 본문
	private String urlPath; // 유튜브URL
	private String thumbUrl; //썸네일URL
	private int likeCnt; //좋아요수
	private int dislikeCnt; //싫어요 수
	private int followCnt; //팔로워수
	private int viewCnt; // 조회수
	private int duration; //영상시간
	private String utbCateGory; //유튜브 카테고리명
	private int utbCateSn; //유튜브 번호
	private String isFamilyFriendly; //모름
	private String titleHashTags; //타이틀 해시태크
	private String descHashTags; //모름;
	private String utbVideoID; //영상아아디ㅣ
	private String authorId; //게시자 아이디
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date yUploadDatetime; //게시글작성일
	private String keywords;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date createDatetime; //생성일
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date updateDatetime; //변경일
}
