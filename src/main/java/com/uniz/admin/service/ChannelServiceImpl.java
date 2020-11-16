package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.Channel;
import com.uniz.admin.mapper.ChannelMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ChannelServiceImpl implements ChannelService {
	
	@Setter(onMethod_ = @Autowired)
	private ChannelMapper channelMapper;

	@Override
	public List<Channel> getChannelList() {
		
		return channelMapper.getChannelList();
	}

	@Override
	public String channelDelete(Long postSN) {
		
		int check = channelCheck(postSN);
		String resultStr = "";

		if (check > 0) {
			try {
				int resultCnt = channelMapper.channelDelete(postSN);

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

	@Override
	public Channel getChannel(Long postSN) {
		
		log.info(channelMapper.getBoard(postSN));
		
		return channelMapper.getBoard(postSN);
	}
	
	public int channelCheck(Long postSN) {
		
		log.info(channelMapper.selectChannel(postSN));
		
		return channelMapper.selectChannel(postSN);
	}
	
}
