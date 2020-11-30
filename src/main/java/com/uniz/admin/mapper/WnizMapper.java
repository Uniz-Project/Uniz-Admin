package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.UWmatchList;
import com.uniz.admin.domain.Wniz;

public interface WnizMapper {
	
	public List<Wniz> getWnizList();

	public int wnizInsert(Wniz wniz);

	public int selectWniz(Wniz wniz);

	public int wnizUpdate(Wniz wniz);

	public int wnizDelete(Wniz wniz);

	public List<UWmatchList> getUWMatchList();

	public List<Wniz> getNotUWMatchList();

	public int selectUWFK(UWmatchList uwlist); //UW에 INSERT 시 유효성검사 (FK없으면 에러)

	public int uwMatchInsert(UWmatchList uwlist);

	public int uwMatchDelete(UWmatchList uwlist);
		
}
