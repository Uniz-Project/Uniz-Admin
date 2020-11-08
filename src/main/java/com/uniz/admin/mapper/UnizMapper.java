package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.Criteria;
import com.uniz.admin.domain.Uniz;

public interface  UnizMapper {
	
	public List<Uniz> getListWithPaging(Criteria cri, Long unizSn);
	
	public int unizInsert(Uniz uniz);
	
	public int selectUniz(Uniz uniz);
	
	public int unizUpdate(Uniz uniz);
	
	public int unizDelete(Uniz uniz);

	public int getCountByUniz(Long unizSn);
	
	public List<Uniz> unizList2();
}
