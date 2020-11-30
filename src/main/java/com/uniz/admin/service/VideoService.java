package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.UWmatchList;
import com.uniz.admin.domain.Video;
import com.uniz.admin.domain.Wniz;

public interface VideoService {

	List<Video> videoList();

	String register(Video video);

	Video getVideo(int videoSn);

}
