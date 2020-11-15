package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.UWmatchList;
import com.uniz.admin.domain.Wniz;

public interface WnizService {

	List<Wniz> wnizList();

	String wnizInsert(Wniz wniz);

	String wnizUpdate(Wniz wniz);

	String wnizDelete(Wniz wniz);

	List<UWmatchList> uwMatchList();

	List<Wniz> uwNotMatchList();

	String uwMatchInsert(UWmatchList uwlist);

	//String uwMatchUpdate(UWmatchList uwlist);

	String uwMatchDelete(UWmatchList uwlist);

}
