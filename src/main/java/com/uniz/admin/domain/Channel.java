package com.uniz.admin.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Channel {
	private Long channelSN;
	private Long postSN;
	private Long userSN;
	private String channelTitle;
	private String channelText;
	private String nick;
	private String postTitle;
	private String postContent;
	private int viewCnt;
	private int likeCnt;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date createDatetime; //가입일시
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date updateDatetime; //변경일시
	
}
