package com.uniz.admin.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnizLayerList {
	private int unizSn;
	private int parentUnizSn;
	private Date createDatedate;
	private Date updateDatedate;
}
