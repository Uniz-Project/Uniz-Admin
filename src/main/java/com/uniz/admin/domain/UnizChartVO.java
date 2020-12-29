package com.uniz.admin.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnizChartVO {
	private Long parnetUnizSN;
	private int count;
	private String unizKeyword;
	
}
