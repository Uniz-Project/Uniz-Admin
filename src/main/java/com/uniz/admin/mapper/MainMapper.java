package com.uniz.admin.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uniz.admin.domain.UnizChartVO;

public interface MainMapper {

	public int newUserCnt(@Param("data")String date);

	public int todayBoardWriteCnt(@Param("data")String today);

	public int todayChannelCreateCnt(@Param("data")String today);

	public int todayRegVideoCnt(@Param("data")String today);

	public List<HashMap<Object, Object>> dailyMemberAmount(HashMap<String, Object> hash);

	public List<HashMap<Object, Object>> dailyChannelAmount(HashMap<String, Object> hash);

	public List<UnizChartVO> pieChartData();

}
