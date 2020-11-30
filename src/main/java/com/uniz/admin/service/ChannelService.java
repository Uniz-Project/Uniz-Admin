package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.Channel;

public interface ChannelService {

	public List<Channel> getChannelList();

	public String channelDelete(Long postSN);

	public Channel getChannel(Long postSN);

}
