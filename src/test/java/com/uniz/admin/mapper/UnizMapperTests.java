package com.uniz.admin.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uniz.admin.domain.Video2;
import com.uniz.admin.utils.Util;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*.xml")
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

		String todayDate = "20/12/10";

		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);
//		List<Video2> Video2 = videoMapper.getVideo2List();

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

		int count = 0;
		// 3. 키워드마다 유니즈 키워드가 있는지 확인하고 없으면 유니즈 키워드로 등록한다.
		for (int i = 0; i < splitKW.length; i++) {
			// 3-1 해당 키워드가 있는지 조회
			// T
			System.out.println("splitKW[" + i + "] : " + splitKW[i]);
			count += 1;
			if (unizMapper.getCountUnizKeyWord(splitKW[i]) <= 0) {
				// 해당 키워드를 유니즈로 등록
				try {

					int resultCnt = unizMapper.unizKeyWordsInsert(searchUnizType, splitKW[i]);

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

	}

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
	public void test1234() {
		log.info(Util.getToday());
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
	public void UnizType10Insert() {
		List<Integer> searchUnizType = new ArrayList<>();

		searchUnizType.add(10);
		searchUnizType.add(1);
		searchUnizType.add(2);
		searchUnizType.add(4);
		searchUnizType.add(6);
		searchUnizType.add(7);

		System.out.println(searchUnizType);
		// 1. 영상리스트 가져오기
		String todayDate = "20/12/10";
		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);

		for (int i = 0; i < Video2.size(); i++) {
			// 2. 영상 리스트 한 행에서
			if (Video2.get(i).getKeywords() != null) {
				String[] splitKeyword = Video2.get(i).getKeywords().split(",");
				log.info(i + "행 영상 키워드 : ");

				for (String keywords : splitKeyword) {
					// 1. 10번 유니즈타입의 유니즈가 있는지 찾는다.
					// 일단 예외처리없이

					int ValidUniz = unizMapper.selectUniz(10, keywords);

					if (ValidUniz > 0) {
						Long unizSN = unizMapper.getUnizsnForKeyword(10, keywords);
						log.info("unizSN : " + unizSN);
						// 10번 유니즈가 있을경우 videounizlist에 등록한다
						unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), unizSN);
					} else if (ValidUniz == 0) {
						// 없을 시 해당 유니즈를 만든다. 10, 1~ 7까지
						int insertResult = unizMapper.unizKeyWordsInsert(searchUnizType, keywords);
						log.info(insertResult);
					}
					// if
				}
			}
		}
	}

	// --------------------------------------------------------------------------------------
	@Test
	public void UnizType1Insert() {

		// 1. 영상리스트 가져오기
		String todayDate = "20/12/10";
		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);

		for (int i = 0; i < Video2.size(); i++) {
			// 2. 영상 리스트 한 행에서
			if (Video2.get(i).getKeywords() != null) {
				String[] splitKeyword = Video2.get(i).getKeywords().split(",");
				log.info(i + "행 영상 키워드 : ");

				for (String keywords : splitKeyword) {

					// 키워드가 제목에 포함되어있는경우
					if (Video2.get(i).getTitle().contains(keywords)) {
						int ValidUniz = unizMapper.selectUniz(1, keywords);

						if (ValidUniz > 0) {
							Long unizSN = unizMapper.getUnizsnForKeyword(1, keywords);
							log.info("unizSN : " + unizSN);
							// 키워드에 제목이 있을경우 유니즈를 등록한다.
							unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), unizSN);

						} else if (ValidUniz == 0) {
							// 없을 시 해당 유니즈를 만든다. 10, 1~ 7까지
							int insertResult = unizMapper.unizKeyWordInsert(1, keywords);
							log.info(insertResult);
						}
					}
					// if
				}
			}
		}
	}

	@Test
	public void UnizType2Insert() {

		// 1. 영상리스트 가져오기
		String todayDate = "20/12/10";
		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);

		for (int i = 0; i < Video2.size(); i++) {
			// 2. 영상 리스트 한 행에서
			if (Video2.get(i).getKeywords() != null) {
				String[] splitKeyword = Video2.get(i).getKeywords().split(",");
				log.info(i + "행 영상 키워드 : ");

				for (String keywords : splitKeyword) {

					// 키워드가 게시자이름에 포함되어있는 경우
					if (Video2.get(i).getAuthorNick().contains(keywords)) {
						int ValidUniz = unizMapper.selectUniz(2, keywords);

						if (ValidUniz > 0) {
							Long unizSN = unizMapper.getUnizsnForKeyword(2, keywords);
							log.info("unizSN : " + unizSN);
							// 키워드에 제목이 있을경우 유니즈를 등록한다.
							unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), unizSN);

						} else if (ValidUniz == 0) {
							// 없을 시 해당 유니즈를 만든다. 10, 1~ 7까지
							int insertResult = unizMapper.unizKeyWordInsert(2, keywords);
							log.info(insertResult);
						}
					}
					// if
				}
			}
		}
	}

	@Test
	public void UnizType4Insert() {

		// 1. 영상리스트 가져오기
		String todayDate = "20/12/10";
		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);

		for (int i = 0; i < Video2.size(); i++) {
			// 2. 영상 리스트 한 행에서
			if (Video2.get(i).getKeywords() != null) {
				String[] splitKeyword = Video2.get(i).getKeywords().split(",");

				if (Video2.get(i).getTitleHashTags() != null) {
					String[] titleHashTag = Video2.get(i).getTitleHashTags().split(",");

					for (String hashTag : titleHashTag) {

						for (String keywords : splitKeyword) {

							// 키워드가 게시자이름에 포함되어있는 경우
							if (hashTag.contains(keywords)) {
								int ValidUniz = unizMapper.selectUniz(4, keywords);

								if (ValidUniz > 0) {
									Long unizSN = unizMapper.getUnizsnForKeyword(4, keywords);
									log.info("unizSN : " + unizSN);
									// 키워드에 제목이 있을경우 유니즈를 등록한다.
									unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), unizSN);

								} else if (ValidUniz == 0) {
									// 없을 시 해당 유니즈를 만든다. 10, 1~ 7까지
									int insertResult = unizMapper.unizKeyWordInsert(4, keywords);
									log.info(insertResult);
								}
							}

						}
					}
				}
			}

		}
	}
	
	//긴 영상
	@Test
	public void UnizType6Insert() {

		// 1. 영상리스트 가져오기
		String todayDate = "20/12/10";
		List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);

		for (int i = 0; i < Video2.size(); i++) {
			// 2. 영상 리스트 한 행에서
			if (Video2.get(i).getKeywords() != null) {
				String[] splitKeyword = Video2.get(i).getKeywords().split(",");
				log.info(i + "행 영상 키워드 : ");

				for (String keywords : splitKeyword) {
					
					//긴영상 
					if (Video2.get(i).getDuration() > 1500) {
						int ValidUniz = unizMapper.selectUniz(6, keywords);

						if (ValidUniz > 0) {
							Long unizSN = unizMapper.getUnizsnForKeyword(6, keywords);
							log.info("unizSN : " + unizSN);
							// 키워드에 제목이 있을경우 유니즈를 등록한다.
							unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), unizSN);

						} else if (ValidUniz == 0) {
							// 없을 시 해당 유니즈를 만든다. 10, 1~ 7까지
							int insertResult = unizMapper.unizKeyWordInsert(6, keywords);
							log.info(insertResult);
						}
					}
					// if
				}
			}
		}
	}
	
	//긴 영상
		@Test
		public void UnizType7Insert() {

			// 1. 영상리스트 가져오기
			String todayDate = "20/12/10";
			List<Video2> Video2 = videoMapper.getTodayVideoData(todayDate);

			for (int i = 0; i < Video2.size(); i++) {
				// 2. 영상 리스트 한 행에서
				if (Video2.get(i).getKeywords() != null) {
					String[] splitKeyword = Video2.get(i).getKeywords().split(",");
					log.info(i + "행 영상 키워드 : ");

					for (String keywords : splitKeyword) {
						
						//짧은 영상
						if (Video2.get(i).getDuration() <= 1500) {
							int ValidUniz = unizMapper.selectUniz(7, keywords);

							if (ValidUniz > 0) {
								Long unizSN = unizMapper.getUnizsnForKeyword(7, keywords);
								log.info("unizSN : " + unizSN);
								// 키워드에 제목이 있을경우 유니즈를 등록한다.
								unizMapper.titleVideoUnizListInsert(Video2.get(i).getVideoSn(), unizSN);

							} else if (ValidUniz == 0) {
								// 없을 시 해당 유니즈를 만든다. 10, 1~ 7까지
								int insertResult = unizMapper.unizKeyWordInsert(7, keywords);
								log.info(insertResult);
							}
						}
						// if
					}
				}
			}
		}
}
