package com.uniz.admin.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class unizPageDTO {
	public int unizCnt;
	public List<Uniz> list;
}
