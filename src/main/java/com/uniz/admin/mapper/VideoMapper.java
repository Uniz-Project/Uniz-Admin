package com.uniz.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uniz.admin.domain.Video;
import com.uniz.admin.domain.Video2;

public interface VideoMapper {

	public List<Video> getVideoList();

	public int videoRegister(Video video);

	public int selectVideo(Video video);

	public Video getVideo(int videoSn);

	public List<Video2> getTodayVideoData(String todayDate);

	public List<Video2> getVideo2List();

	public int videoDelete(@Param("videoSN")Long videoSN);

	public int videoUpdate(Video video);

	public int getVideoCount();

	public List<Video2> getPagingVideoData(@Param("start")int start, @Param("length")int length);

	public void deletePlayLog(@Param("videoSN")Long videoSN);

	
}
