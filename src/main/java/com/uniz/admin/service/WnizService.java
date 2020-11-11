package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.Wniz;

public interface WnizService {

	List<Wniz> wnizList();

	String wnizInsert(Wniz wniz);

	String wnizUpdate(Wniz wniz);

	String wnizDelete(Wniz wniz);

}
