package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.Video;
import com.uniz.admin.domain.Video2;

public interface VideoMapper {

	public List<Video> getVideoList();

	public int videoRegister(Video video);

	public int selectVideo(Video video);

	public Video getVideo(int videoSn);

	public List<Video2> getTodayData(String todayDate);
	
	
}
