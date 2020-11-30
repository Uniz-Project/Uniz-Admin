package com.uniz.admin.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnizLayer {
	private int unizSn;
	private int parentUnizSn;
	private String parentUnizKeyword;
	private String childUnizKeyword;	
	private Date createDatedate;
	private Date updateDatedate;
}
