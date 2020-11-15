package com.uniz.admin.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Uniz {
	private int unizSn;
	private int unizTypeSn;
	private String unizKeyword;
	private String imgUrl;
	private String enable;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDatetime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateDatetime;
}
