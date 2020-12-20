package com.uniz.admin.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApplyCreatorVO {
		
	private Long applySN;
	private Long userSN;
	private String userID;
	private String nick;
	private String channelTitle;
	private String category;
	private String email;
	private String statusName;
	private int state;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date createDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date updateDateTime;
	
	private int userTypeSN;
	private String userType;

	private List<ApplyAttachVO> attachList;
		
}
