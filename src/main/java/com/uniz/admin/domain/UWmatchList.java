package com.uniz.admin.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UWmatchList {
	private int wnizSn;
	private int unizSn;
	private int maxUnizPoint;
	private int minUnizPoint;
	private int priority;
	private Date createDateTime;
	private Date updateDateTime;
}

