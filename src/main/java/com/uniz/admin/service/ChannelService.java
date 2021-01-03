package com.uniz.admin.service;

import java.util.List;

import com.uniz.admin.domain.Channel;

public interface ChannelService {

	public List<Channel> getChannelList();

	public String channelDelete(Long channelSN);

	public Channel getChannel(Long channelSN);

	public List<Channel> getChannelBoardList(Long channelSN);

	public int updateChannel(Channel channel);

	public int cascadeDeleteChannel(Long channelSN, List<Channel> channelList);

	public Channel getChannelPost(Long postSN);

	public void updateChannelPost(Channel channel);

	public String deleteChannelPost(Long postSN);

	int cascadeDeleteChannelBoard(Long postSN);

}
