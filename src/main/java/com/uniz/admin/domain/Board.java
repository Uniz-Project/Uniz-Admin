package com.uniz.admin.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Board {
	private Long userSN;
	private Long postSN;
	private String title;
	private String nick;
	private String boardTitle;
	private String postContent;
	private int viewCnt;
	private int likeCnt;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date createDatetime; //가입일시
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date updateDatetime; //변경일시
	
}
