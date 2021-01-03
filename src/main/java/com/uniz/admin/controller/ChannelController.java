package com.uniz.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniz.admin.domain.Channel;
import com.uniz.admin.service.ChannelService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class ChannelController {
	
	private ChannelService channelService;
	
	@GetMapping("/admin/channel")
	public String viewChannelList() {
		
		return "admin/channelList";
	}
	
	@GetMapping("/admin/channel/list")
	public @ResponseBody Map<String, Object> channelList(){
		
		List<Channel> channelList = channelService.getChannelList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", channelList);
		log.info("channelList .... : " + channelList);
		return map; 
	}
	
	@PostMapping("/admin/channel/delete/{channelSN}")
	public @ResponseBody Map<String, Object> channelDelete(@PathVariable Long channelSN) {
		
		String result = channelService.channelDelete(channelSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		log.info("channelDelete"+ map);
		
		return map;
	}

	
	@GetMapping("/admin/channel/detail/{postSN}")
	public String channelDetail(@PathVariable Long postSN, Model model) {
		
		log.info("postSN ....:"+postSN);
		
		
		Channel channel = channelService.getChannelPost(postSN);
		
		log.info("channel ...." + channel);
		
		model.addAttribute("channel",channel); 
		
		return "/admin/channelDetail";
	}
	
	@GetMapping("/admin/channel/channelTitle/{channelSN}")
	public @ResponseBody Map<String, Object> channelTitle(@PathVariable Long channelSN) {
		
		List<Channel> channelBoardList = channelService.getChannelBoardList(channelSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", channelBoardList);
		return map; 
	}
	
	@GetMapping("/admin/channel/update/{channelSN}")
	public String channelUpdate(@PathVariable Long channelSN, Model model) {
		Channel channel = channelService.getChannel(channelSN);
		
		model.addAttribute("channel", channel);
		
		return "/admin/channelUpdate";
		
	}
	@PostMapping("/admin/channel/update")
	public String boardUpdatePost(Channel channel) {
		
		channelService.updateChannel(channel);
		
		
		return "redirect:/admin/channel";
	}
	
	@GetMapping("/admin/channel/board/update/{postSN}")
	public String updateChannelBoardPost(@PathVariable Long postSN, Model model) {
		
		Channel channel = channelService.getChannelPost(postSN);
		
		log.info("channel ...." + channel);
		
		model.addAttribute("channel",channel); 
		
		return "/admin/channelPostUpdate";
	}
	
	@PostMapping("/admin/channel/board/update")
	public String updateChannelBoardPost(Channel channel) {
		
		log.info("channel :" + channel);
		
		channelService.updateChannelPost(channel);
		
		return "redirect:/admin/channel";
	}
	
	@PostMapping("/admin/channel/board/delete/{postSN}")
	public @ResponseBody Map<String, Object> channelPostDelete(@PathVariable Long postSN) {
		
		String result = channelService.deleteChannelPost(postSN);
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		log.info("channelDelete"+ map);
		
		return map;
	}
}
