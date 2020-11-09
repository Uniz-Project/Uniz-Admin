package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.Criteria;
import com.uniz.admin.domain.Uniz;
import com.uniz.admin.domain.UnizLayer;

public interface  UnizMapper {
	
	public List<Uniz> getListWithPaging(Criteria cri, Long unizSn);
	
	public int unizInsert(Uniz uniz);
	
	public int selectUniz(Uniz uniz);
	
	public int unizUpdate(Uniz uniz);
	
	public int unizDelete(Uniz uniz);

	public int getCountByUniz(Long unizSn);
	
	public List<Uniz> unizList2();

	public List<UnizLayer> unizLayerList();

	public int unizLayerDelete(UnizLayer unizLayer);

	public int unizLayerUpdate(UnizLayer unizLayer);

	public int unizLayerInsert(UnizLayer unizLayer);

	public int unizLayerCheck(UnizLayer unizLayer);

	public List<Uniz> unizNotLayerList();
}
