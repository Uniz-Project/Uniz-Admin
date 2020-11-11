package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.Wniz;

public interface WnizMapper {
	
	public List<Wniz> getWnizList();

	public int wnizInsert(Wniz wniz);

	public int selectWniz(Wniz wniz);

	public int wnizUpdate(Wniz wniz);

	public int wnizDelete(Wniz wniz);
		
}
