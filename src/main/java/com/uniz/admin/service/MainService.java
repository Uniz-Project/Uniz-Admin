package com.uniz.admin.service;

import java.util.HashMap;
import java.util.List;

import com.uniz.admin.domain.UnizChartVO;

public interface MainService {

	public int newUserCnt(String today);

	public int todayBoardWriteCnt(String today);

	public int todayChannelCreateCnt(String today);

	public int todayRegVideoCnt(String today);

	public List<HashMap<Object, Object>> dailyMemberAmount();

	public List<HashMap<Object, Object>> dailyChannelAmount();

	public List<UnizChartVO> pieChartData();


}
