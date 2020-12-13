package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.UWmatchList;
import com.uniz.admin.domain.Video;
import com.uniz.admin.domain.Wniz;

public interface VideoService {

	public List<Video> videoList();

	public String register(Video video);

	public Video getVideo(int videoSn);

	public String videoDelete(Long videoSN);

	public String videoUpdate(Video video);

}
