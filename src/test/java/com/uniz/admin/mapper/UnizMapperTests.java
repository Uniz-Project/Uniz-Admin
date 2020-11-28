package com.uniz.admin.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uniz.admin.domain.Video2;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UnizMapperTests {
	@Setter(onMethod_ = @Autowired)
	private UnizMapper unizMapper;
	@Setter(onMethod_ = @Autowired)
	private VideoMapper videoMapper;
	
	@Test
	public void AutoVideoInsert() {
		//1. VideoData2  테이블에서 오늘날짜로 입력된 데이터를 가져온다.
		String todayDate = "20/11/24";
		 
		List<Video2> Video2= videoMapper.getTodayData(todayDate);
		
		Video2.forEach(s -> s.getKeywords());
		
	}
	
	//2. 행에서 keywords마다 , 구분자로 잘라서 리스트로 담고있는다
	
	//3. keywords에서 , 구분자로 짜른 키워드 한개마다 Uniz 테이블에서 유니즈 키워드가 있는지 확인한다.
	
	//4. 유니즈 키워드가 있을경우 다음으로 넘어가고 , 유니즈 키워드가 없을경우 새로운 유니즈 키워드로 등록한다.
	
	//--------------------------------------------------------------------------------------
	
	//1. 오늘 등록된 영상을 조회한다.
	
	//2. VideoData2.title 에 

}
