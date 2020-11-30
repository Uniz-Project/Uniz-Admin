package com.uniz.admin.mapper;

import java.util.ArrayList;
import java.util.Arrays;
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
	public void autoVideoInsert() {
		// 1. VideoData2 테이블에서 오늘날짜로 입력된 데이터를 가져온다.
		// 2. 행에서 keywords마다 , 구분자로 잘라서 리스트로 담고있는다
		// 3. keywords에서 , 구분자로 짜른 키워드 한개마다 Uniz 테이블에서 유니즈 키워드가 있는지 확인한다.
		// 4. 유니즈 키워드가 있을경우 다음으로 넘어가고 , 유니즈 키워드가 없을경우 새로운 유니즈 키워드로 등록한다.

//		String todayDate = "20/11/24";

//		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);

		List<Video2> Video2 = videoMapper.getVideo2List();

		// 2. 행에서 keywords마다 , 구분자로 잘라서 배열로 담고있는다
		String[] splitKW = getSplitKeyWord(Video2);

		List<Integer> searchUnizType = new ArrayList<>();

		searchUnizType.add(10);
		searchUnizType.add(1);
		searchUnizType.add(2);
		searchUnizType.add(4);
		searchUnizType.add(6);
		searchUnizType.add(7);

		String resultStr = "";
		
		log.info("자른길이 --------------"+splitKW.length);
		
		int count =0;
		// 3. 키워드마다 유니즈 키워드가 있는지 확인하고 없으면 유니즈 키워드로 등록한다.
		for (int i = 0; i < splitKW.length; i++) {
			// 3-1 해당 키워드가 있는지 조회
			// T
			System.out.println("splitKW["+i+"] : "+ splitKW[i]);
			count += 1;
			if (unizMapper.getCountUnizKeyWord(splitKW[i]) <= 0) {
				// 해당 키워드를 유니즈로 등록
				try {
					
					int resultCnt = unizMapper.unizKeyWordInsert(searchUnizType, splitKW[i]);

					if (resultCnt > 0) {
						resultStr = "success";
					} else {
						resultStr = "fail";
					}
				} catch (Exception e) {
					e.printStackTrace();
					resultStr = "fail";
				}
			} else {

				resultStr = "duplicate";
			}
			log.info(i + "번쨰 결과 --------" + resultStr);
		}
		
		log.info("---------------------------------------------Count : " + count);

	}

//	public boolean getUnizKeyWordIsExist(String keyWord) {
//		return unizMapper.getCountUnizKeyWord(keyWord) >= 1;
//	}
	@Test
	public void test2() {
		List<Integer> searchUnizType = new ArrayList<>();

		searchUnizType.add(10);
		searchUnizType.add(1);
		searchUnizType.add(2);
		searchUnizType.add(4);
		searchUnizType.add(6);
		searchUnizType.add(7);

		System.out.println(searchUnizType);

	}
	@Test
	public void getSplitKeyWordTest() {
		
		List<Video2> Video2 = videoMapper.getVideo2List();
		
		// 2. 행에서 keywords마다 , 구분자로 잘라서 배열로 담고있는다
		String[] splitKW = getSplitKeyWord(Video2);
	}
	
	public String[] getSplitKeyWord(List<Video2> Video2) {
		String keyWords = "";

		for (int i = 0; i < Video2.size(); i++) {
			System.out.println("[" + i + "]:" + Video2.get(i).getKeywords());
			keyWords += Video2.get(i).getKeywords();
		}
		System.out.println("전체키워드 : " + keyWords);

		String[] splitKeyWord = keyWords.split(",");

		for (int i = 0; i < splitKeyWord.length; i++) {
			System.out.println("키워드 [" + i + "]" + splitKeyWord[i]);
		}

		return splitKeyWord;
	}

	// --------------------------------------------------------------------------------------
	@Test
	public void autoVideoUnizListInsert() {

		// 1. 영상 리스트를 가져온다.
		String todayDate = "20/11/24";
		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);

		String resultStr = "";
		// 2. 영상 리스트 한 행에서 title과 키워드들을 비교한다.
		for (int i = 0; i < Video2.size(); i++) {
			String[] splitKeyWord = Video2.get(i).getKeywords().split(",");
			
			System.out.println("get i ---" +Video2.get(i));
			for (int j = 0; j < splitKeyWord.length; j++) {
				
				try {
					//기본 유니즈 카테고리등록
					unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), splitKeyWord[j], 10);
				}catch(Exception e){
					e.printStackTrace();
					resultStr = "fail";
				}
				log.info("-----헙1--------------");
				// 제목에 해당 키워드가 있으면 Type1
				if (Video2.get(i).getTitle().contains(splitKeyWord[j])) {

					// 3. 비교 후 해당 키워드가 존재하면 해당 키워드의 유니즈를 VIDEOUNLIST에 등록한다
					try {
						unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), splitKeyWord[j], 1);

						
					} catch (Exception e) {
						e.printStackTrace();
						resultStr = "fail";
					}
				}
				log.info("-----헙2--------------");
				//Type2 = 게시자닉네임과 키워드
				if (Video2.get(i).getAuthorNick().contains(splitKeyWord[j])) {
					// 3. 비교 후 해당 키워드가 존재하면 해당 키워드의 유니즈를 VIDEOUNLIST에 등록한다
					try {
						unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), splitKeyWord[j], 2);	
					} catch (Exception e) {
						e.printStackTrace();
						resultStr = "fail";
					}
				}
				log.info("-----헙4--------------");
				//Type4 해시태그와 키워드
				if (Video2.get(i).getTitleHashTags().contains(splitKeyWord[j])) {
					// 3. 비교 후 해당 키워드가 존재하면 해당 키워드의 유니즈를 VIDEOUNLIST에 등록한다
					try {
						unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), splitKeyWord[j], 4);	
					} catch (Exception e) {
						e.printStackTrace();
						resultStr = "fail";
					}
				}	
				
				log.info("-----헙--------------");
//				//Type6
//				if (Video2.get(i).getDuration() > 1000 ) {
//					//키워드 전체를 등록해야된다 
////					List<String> keywords = new ArrayList<>(Arrays.asList(splitKeyWord));
//					
//					try {
////						unizMapper.titleVideoUnizListInsertAllKeyword(Video2.get(i).getVideoSn(),keywords, 6);	
//						log.info("-----헙--------------");
//						unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), splitKeyWord[j], 6);	
//					} catch (Exception e) {
//						e.printStackTrace();
//						resultStr = "fail";
//					}
//				}	
//				
//				log.info("-----헙--------------");
//				//Type7
//				if (Video2.get(i).getDuration() < 1000 ) {
//					// 3. 비교 후 해당 키워드가 존재하면 해당 키워드의 유니즈를 VIDEOUNLIST에 등록한
//					//List<String> keywords = new ArrayList<>(Arrays.asList(splitKeyWord));
//					try {
//						//unizMapper.titleVideoUnizListInsertAllKeyword(Video2.get(i).getVideoSn(), keywords, 7);	
//						unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), splitKeyWord[j], 7);	
//					} catch (Exception e) {
//						e.printStackTrace();
//						resultStr = "fail";
//					}
//				}	

			}
		}

		System.out.println(resultStr);

	}

	@Test
	public void autoTest() {
		// 1. 영상 리스트를 가져온다.
		String todayDate = "20/11/24";
		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);
		
		String resultStr = "";
		// 2. 영상 리스트 한 행에서 title과 키워드들을 비교한다.
		for (int i = 0; i < 1; i++) {
			String[] splitKeyWord = Video2.get(i).getKeywords().split(",");
			log.info("-------------------" + i + "번째 행 키워드뭉치 : " + splitKeyWord);
			for (int j = 0; j < splitKeyWord.length; j++) {

				// 제목에 해당 키워드가 있으면
				if (Video2.get(i).getTitle().contains(splitKeyWord[j])) {

					// 3. 비교 후 해당 키워드가 존재하면 해당 키워드의 유니즈를 VIDEOUNLIST에 등록한다
					try {
						int resultCnt = unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(),
								splitKeyWord[j],1);

						if (resultCnt > 0) {
							resultStr = "success";
						} else {
							resultStr = "fail";
						}

					} catch (Exception e) {
						e.printStackTrace();
						resultStr = "fail";
					}
				}
			}
		}

		System.out.println(resultStr);	
	}
}
