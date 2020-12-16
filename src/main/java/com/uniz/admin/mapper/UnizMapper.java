package com.uniz.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uniz.admin.domain.Criteria;
import com.uniz.admin.domain.Uniz;
import com.uniz.admin.domain.UnizLayer;

public interface  UnizMapper {
	
	public List<Uniz> getListWithPaging(Criteria cri, Long unizSn);
	
	public int unizInsert(Uniz uniz);
	
	public int selectUniz(@Param("unizTypeSn")int unizTypeSn, @Param("unizKeyword")String unizKeyword);
	
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

	public int getCountUnizKeyWord(String keyWord);

	public int unizKeyWordInsert(@Param("searchUnizType") int searchUnizType, @Param("keyWord")String keyWord);
	
	public int unizKeyWordsInsert(@Param("searchUnizType") List<Integer> searchUnizType, @Param("keyWord")String keyWord);

	public int titleVideoUnizListInsert(@Param("videoSN")int videoSN, @Param("unizSN")Long unizSN);

	public int titleVideoUnizListInsertAllKeyword(int videoSn, @Param("splitKeyWord")List<String> splitKeyWord, @Param("UnizTypeSN")int unizTypeSN);
	
	public Long getUnizsnForKeyword(@Param("UnizTypeSN")int UnizTypeSN, @Param("UnizKeyWord")String UnizKeyWord);

	public int getUnizCount();

	public List<Uniz> getPagingUniz(@Param("start")int start,@Param("length") int length);
}
