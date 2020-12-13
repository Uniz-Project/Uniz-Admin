package com.uniz.admin.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Video {
	
	private int videoSN; //비디오번호
	private String title; //제목
	private String authorId; //게시자 아이디
	private String authorNick; //게시자 닉네임
	private String urlPath; // 유튜브URL
	private String thumbUrl; //썸네일URL
	private int likeCnt; //좋아요수
	private int followCnt; //좋아요수
	private int viewCnt; // 조회수
	private int utbCateSn; //유튜브 카테고리
//	
	private String utbVideoID;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date createDatetime; //생성일
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date updateDatetime; //변경일
}
