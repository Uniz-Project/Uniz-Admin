package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniz.admin.domain.Channel;
import com.uniz.admin.mapper.ChannelMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
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
	
	@Transactional
	@Override
	public String channelDelete(Long channelSN) {
		
		String resultStr = "";
			try {
				//DB에 문제가 있을 수 있으니 예외처리
				//DELETE쿼리 실행
				
				List<Channel> channelList = channelMapper.getChannelBoardList(channelSN);
				int resultCnt = cascadeDeleteChannel(channelSN, channelList);

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
		
		//js에서 ajax호출시 반환받은 resultStr값으로 상태에 따른 alert출력.
		return resultStr;
	}
	
	@Override
	public Channel getChannel(Long channelSN) {
		
		log.info(channelMapper.getChannel(channelSN));
		
		return channelMapper.getChannel(channelSN);
	}
	
	public int channelCheck(Long postSN) {
		
		log.info(channelMapper.selectChannel(postSN));
		
		return channelMapper.selectChannel(postSN);
	}

	@Override
	public List<Channel> getChannelBoardList(Long channelSN) {
		
		return channelMapper.getChannelBoardList(channelSN);
	}

	@Override
	public int updateChannel(Channel channel) {
		
		return channelMapper.updateChannel(channel);
	}
	
	@Transactional
	@Override
	public int cascadeDeleteChannel(Long channelSN, List<Channel> channelList) {
		final int SUCCESS = 1;
		final int FAIL= -1;
		try {
			
			if(channelList.size() >= 1) {
				//이미지삭제
				channelMapper.deleteBoardImg(channelList);
				
				//댓글삭제
				channelMapper.deleteBoardReply(channelList);
				log.info("댓글삭제완료");
				
				//본문삭제
				channelMapper.deleteBoardContent(channelList);
				log.info("본문삭제완료");
			}
			//게시물삭제
			channelMapper.deleteBoardPost(channelSN);
			log.info("게시물삭제완료");
			
			channelMapper.deleteChannel(channelSN);
			return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
		
	}
	@Transactional
	@Override
	public int cascadeDeleteChannelBoard(Long postSN) {
		final int SUCCESS = 1;
		final int FAIL= -1;
		try {
				//이미지삭제
				channelMapper.deleteBoardImgOne(postSN);
				
				//댓글삭제
				channelMapper.deleteBoardReplyOne(postSN);
				log.info("댓글삭제완료");
				
				//본문삭제
				channelMapper.deleteBoardContentOne(postSN);
				log.info("본문삭제완료");
				
				channelMapper.deleteBoardPostOne(postSN);
				return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return FAIL;
		}
		
	}

	@Override
	public Channel getChannelPost(Long postSN) {
		
		Channel channel = channelMapper.getChannelPost(postSN);
		
		return channel;
	}
	
	@Transactional
	@Override
	public void updateChannelPost(Channel channel) {
		
		int postResult = channelMapper.updateChannelPost(channel);
		int contentResult = channelMapper.updateChannelContent(channel);
	}

	@Override
	public String deleteChannelPost(Long postSN) {
		
		String resultStr = "";
		try {
			//DB에 문제가 있을 수 있으니 예외처리
			//DELETE쿼리 실행
			
			int resultCnt = cascadeDeleteChannelBoard(postSN);
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
	
	//js에서 ajax호출시 반환받은 resultStr값으로 상태에 따른 alert출력.
	return resultStr;
	}

	@Override
	public List<Channel> getChannelPostWithFile(Long postSN) {
		
		return channelMapper.getChannelPostWithFile(postSN);
	}
}
