package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.DataTableDTO;
import com.uniz.admin.domain.Video;
import com.uniz.admin.mapper.VideoMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

	@Setter(onMethod_ = @Autowired)
	private VideoMapper videoMapper;

	@Override
	public DataTableDTO videoList(DataTableDTO dto,int draw, int start, int length) {
		
		log.info("service on .....");
		int total = videoMapper.getVideoCount();
		log.info("total : " + total);
		List data = videoMapper.getPagingVideoData(start,length);
		
		log.info("data : " + data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(total);
		dto.setRecordsTotal(total);
		dto.setData(data);
		
		log.info("dto : " + dto); 
		
		return dto;
	}

	@Override
	public String register(Video video) {
		
		//비디오 등록하기전 필드에 입력한 카테고리SN이 유니즈키워드에 등록되어있는지 확인
		int check = videoCheck(video);
		
		String resultStr = "";
		
		//등록되어 있는 경우 
		if (check >= 1) {
			try {
				//DB에 문제가 있을 수 있으니 예외처리
				//쿼리 실행
				int resultCnt = videoMapper.videoRegister(video);
				
				if (resultCnt > 0) {
					//제대로 동작했을 경우 "success" 반환
					resultStr = "success";
				} else {
					//문제가 있을 시 "fail"
					resultStr = "fail";
				}
			} catch (Exception e) {
				// DB에 문제가 있을 시 역시 "fail"
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			// 해당 유니즈카테고리가 없을 경우 "duplicate"
			resultStr = "duplicate";
		}
		
		//js에서 ajax호출시 반환받은 resultStr값으로 상태에 따른 alert출력.
		return resultStr;
	}

	private int videoCheck(Video video) {
		
		return videoMapper.selectVideo(video);
		
	}

	@Override
	public Video getVideo(int videoSn) {
		
		return videoMapper.getVideo(videoSn);
	}

	@Override
	public String videoDelete(Long videoSN) {
		final String SUCCESS= "SUCCESS";
		final String FAIL = "FAIL";
		final String DB_ERROR = "DB ERROR";
		
		if(videoSN != null) {
			try {
				int result = videoMapper.videoDelete(videoSN);
				
				return SUCCESS;
			}catch(Exception e) {
				e.printStackTrace();
				return DB_ERROR;
			}
		}
		
		return FAIL;
		
	}
	
	@Override
	public String videoUpdate(Video video) {
		final String SUCCESS= "SUCCESS";
		final String FAIL = "FAIL";
		final String DB_ERROR = "DB ERROR";
		
		if(video != null) {
			try {
				int result = videoMapper.videoUpdate(video);
				
				return SUCCESS;
			}catch(Exception e) {
				e.printStackTrace();
				return DB_ERROR;
			}
		}
		
		return FAIL;
		
	}
}
