package com.weenko.pbx.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weenko.pbx.dao.ChannelRepository;
import com.weenko.pbx.dao.DndRepository;
import com.weenko.pbx.gui.LocalFlash;
import com.weenko.pbx.model.Channel;
import com.weenko.pbx.service.ChannelService;

@Controller
public class ChannelsController {

	static Logger logger = LoggerFactory.getLogger(ChannelsController.class);
	
	@Autowired
	ChannelRepository channelRepository;

	@Autowired
	DndRepository dndRepository;
	
	@Autowired
	ChannelService channelService;

	@PreAuthorize("hasPermission('Channels','view')")
	@GetMapping("/channels")
	String getAllChannels(Model model) {
		model.addAttribute("allChannels", channelRepository.findAll());
		return "channels/list";
	}

	@PreAuthorize("hasPermission('Channels','edit')")
	@GetMapping("/channels/add")
	String getCreatePage(Model model) {
		model.addAttribute("channel", new Channel());
		model.addAttribute("allDnds", dndRepository.findAll());
		return "channels/edit";
	}

	@PreAuthorize("hasPermission('Channels','edit')")
	@GetMapping("/channels/edit/{channelID}")
	String getEditPage(Model model, @PathVariable long channelID) {
		model.addAttribute("channel", channelRepository.findById(channelID).get());
		model.addAttribute("allDnds", dndRepository.findAll());
		return "channels/edit";
	}

	@PreAuthorize("hasPermission('Channels','edit')")
	@PostMapping("/channels/save")
	String saveChannel(Model model, @ModelAttribute Channel channel, RedirectAttributes redirectAttributes) {
		if(channel.getId() != null && channel.getId() > 0) {
			if(channelService.saveExistingChannel(channel)) {
				redirectAttributes.addFlashAttribute("flash", new LocalFlash("channels.crud.save.flash.success", "success"));
			} else
				redirectAttributes.addFlashAttribute("flash", new LocalFlash("channels.crud.save.flash.error", "error"));
		} else {
			if(channelService.createNewChannel(channel))
				redirectAttributes.addFlashAttribute("flash", new LocalFlash("channels.crud.save.flash.success", "success"));
			else
				redirectAttributes.addFlashAttribute("flash", new LocalFlash("channels.crud.save.flash.error", "error"));
		}

		return "redirect:/channels";
	}

	@PreAuthorize("hasPermission('Channels','edit')")
	@GetMapping(value = "/channels/delete/{channelID}")
	public String deleteChannel(@PathVariable long channelID, RedirectAttributes redirectAttributes) {
		Optional<Channel> channel = channelRepository.findById(channelID);
		if(channelService.deleteExistingChannel(channel.get()))
			redirectAttributes.addFlashAttribute("flash", new LocalFlash("channels.crud.delete.flash.success", "success"));
		else
			redirectAttributes.addFlashAttribute("flash", new LocalFlash("channels.crud.delete.flash.error", "error"));

		return "redirect:/channels";
	}

}