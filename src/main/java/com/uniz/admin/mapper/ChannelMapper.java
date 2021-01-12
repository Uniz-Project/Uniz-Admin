package com.uniz.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uniz.admin.domain.Channel;

public interface ChannelMapper {

	public List<Channel> getChannelList();

	public int selectChannel(Long postSN);

	public Channel getBoard(Long postSN);

	public int channelDelete(Long postSN);

	public List<Channel> getChannelBoardList(@Param("channelSN")Long channelSN);

	public Channel getChannel(@Param("channelSN")Long channelSN);

	public int updateChannel(Channel channel);

	public void deleteBoardImg(@Param("channelList")List<Channel> channelList);

	public void deleteBoardReply(@Param("channelList")List<Channel> channelList);

	public void deleteBoardContent(@Param("channelList")List<Channel> channelList);

	public int deleteBoardPost(@Param("channelSN")Long channelSN);

	public void deleteChannel(@Param("channelSN")Long channelSN);

	public Channel getChannelPost(@Param("postSN")Long postSN);

	public int updateChannelPost(Channel channel);

	public int updateChannelContent(Channel channel);

	public void deleteBoardImgOne(Long postSN);

	public void deleteBoardReplyOne(Long postSN);

	public void deleteBoardContentOne(Long postSN);

	public void deleteBoardPostOne(Long postSN);

	public List<Channel> getChannelPostWithFile(Long postSN);
	
}
