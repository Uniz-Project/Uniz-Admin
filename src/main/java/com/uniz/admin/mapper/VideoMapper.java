package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.Video;

public interface VideoMapper {

	List<Video> getVideoList();

	int videoRegister(Video video);

	int selectVideo(Video video);

	Video getVideo(int videoSn);
	
	
}
