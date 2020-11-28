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
		//삭제하려는 게시물이 존재하면
		if (check > 0) {
			try {
				//DB에 문제가 있을 수 있으니 예외처리
				//DELETE쿼리 실행
				int resultCnt = channelMapper.channelDelete(postSN);

				if (resultCnt > 0) {
					//제대로 동작했을 경우 "success" 반환
					resultStr = "success";
				} else {
					//문제가 있을 시 "fail"
					resultStr = "fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				// DB에 문제가 있을 시 역시 "fail"
				resultStr = "fail";
			}
		} else {
			// 해당 게시물이 존재하지 않을경우 "duplicate"
			resultStr = "duplicate";
		}
		
		//js에서 ajax호출시 반환받은 resultStr값으로 상태에 따른 alert출력.
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
