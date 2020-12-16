package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.Criteria;
import com.uniz.admin.domain.DataTableDTO;
import com.uniz.admin.domain.Uniz;
import com.uniz.admin.domain.UnizLayer;
import com.uniz.admin.domain.unizPageDTO;

public interface UnizService {
	
	public List<Uniz> unizList(Criteria cri, Long unizSn);
	
	public DataTableDTO unizList2(DataTableDTO dto, int draw, int start, int length);
		
	public String unizInsert(Uniz uniz);
	
	public String unizUpdate(Uniz uniz);
	
	public String unizDelete(Uniz uniz);
	
	public List<UnizLayer> unizLayerList();

	public String unizLayerInsert(UnizLayer unizLayer);

	public String unizLayerUpdate(UnizLayer unizLayer);

	public String unizLayerDelete(UnizLayer unizLayer);

	public List<Uniz> unizNotLayerList();
}
