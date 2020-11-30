package com.uniz.admin.mapper;

import java.util.List;

import com.uniz.admin.domain.Channel;

public interface ChannelMapper {

	public List<Channel> getChannelList();

	public int selectChannel(Long postSN);

	public Channel getBoard(Long postSN);

	public int channelDelete(Long postSN);
	
}
