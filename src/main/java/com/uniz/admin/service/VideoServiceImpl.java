package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.Video;
import com.uniz.admin.mapper.VideoMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

	@Setter(onMethod_ = @Autowired)
	private VideoMapper videoMapper;

	@Override
	public List<Video> videoList() {

		return videoMapper.getVideoList();
	}

	@Override
	public String register(Video video) {
		
		int check = videoCheck(video);
		
		String resultStr = "";

		if (check >= 1) {
			try {
				int resultCnt = videoMapper.videoRegister(video);

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

		return resultStr;
	}

	private int videoCheck(Video video) {
		
		return videoMapper.selectVideo(video);
		
	}

	@Override
	public Video getVideo(int videoSn) {
		
		return videoMapper.getVideo(videoSn);
	}
	

	


}
