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
	public String main() {
		
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
	
	@PostMapping("/admin/channel/delete/{postSN}")
	public @ResponseBody Map<String, Object> channelDelete(@PathVariable Long postSN) {
		
		String result = channelService.channelDelete(postSN);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		
		log.info("channelDelete"+ result);
		
		return map;
	}

	
	@GetMapping("/admin/channel/detail/{postSN}")
	public String channelDetail(@PathVariable Long postSN, Model model) {
		
		log.info("postSN ....:"+postSN);
		
		Channel channel = channelService.getChannel(postSN);
		
		log.info("channel ...." + channel);
		
		model.addAttribute("channel",channel); 
		
		return "/admin/channelDetail";
	}
	
}
