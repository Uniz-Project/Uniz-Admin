package com.uniz.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.UnizChartVO;
import com.uniz.admin.mapper.MainMapper;
import com.uniz.admin.utils.Util;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MainServiceImpl implements MainService{
	
	@Setter(onMethod_ = @Autowired)
	private MainMapper mapper;
	
	@Override
	public int newUserCnt(String date) {
		
		return mapper.newUserCnt(date);
	}

	@Override
	public int todayBoardWriteCnt(String today) {
		
		return mapper.todayBoardWriteCnt(today);
	}

	@Override
	public int todayChannelCreateCnt(String today) {
		
		return mapper.todayChannelCreateCnt(today);
	}

	@Override
	public int todayRegVideoCnt(String today) {
		
		return mapper.todayRegVideoCnt(today);
	}

	@Override
	public List<HashMap<Object, Object>> dailyMemberAmount() {
		
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("beforeDate", Util.getBefore7Days());
		hash.put("date", Util.getToday());
		
		List<HashMap<Object, Object>> returnList = mapper.dailyMemberAmount(hash);
		log.info("returnList : " +returnList);
		int returnListSize = returnList.size();
		
		List<String> dataList = Util.getBeforeDays();
		int listSize = dataList.size();
		log.info("dataList"+ dataList);
		
		List<HashMap<Object, Object>> list = new ArrayList<HashMap<Object, Object>>();
		for(int i=0; i<listSize; i++) {
			String date = dataList.get(i);
			
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("createDateTime", date);
			map.put("amount", "0");
			
			for (int j=0; j<returnListSize; j++) {
				String createDate = returnList.get(j).get("CREATEDATETIME").toString();
				String amount = returnList.get(j).get("AMOUNT").toString();
				
				if(date.equals(createDate)) {
					map.put("amount", amount);
					break;
				}
			}
			list.add(map);
		}
		
		return list;
	}

	@Override
	public List<HashMap<Object, Object>> dailyChannelAmount() {
		
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("beforeDate", Util.getBefore7Days());
		hash.put("date", Util.getToday());
		
		List<HashMap<Object, Object>> returnList = mapper.dailyChannelAmount(hash);
		log.info("returnList : " +returnList);
		int returnListSize = returnList.size();
		
		List<String> dataList = Util.getBeforeDays();
		int listSize = dataList.size();
		log.info("dataList"+ dataList);
		
		List<HashMap<Object, Object>> list = new ArrayList<HashMap<Object, Object>>();
		for(int i=0; i<listSize; i++) {
			String date = dataList.get(i);
			
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("createDateTime", date);
			map.put("amount", "0");
			
			for (int j=0; j<returnListSize; j++) {
				String createDate = returnList.get(j).get("CREATEDATETIME").toString();
				String amount = returnList.get(j).get("AMOUNT").toString();
				
				if(date.equals(createDate)) {
					map.put("amount", amount);
					break;
				}
			}
			list.add(map);
		}
		
		return list;
	}

	@Override
	public List<UnizChartVO> pieChartData() {
		
		return mapper.pieChartData();
	}
}
