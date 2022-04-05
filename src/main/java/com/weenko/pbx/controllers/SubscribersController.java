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

import com.weenko.pbx.dao.DndRepository;
import com.weenko.pbx.dao.SubscriberRepository;
import com.weenko.pbx.gui.LocalFlash;
import com.weenko.pbx.model.Subscriber;

@Controller
public class SubscribersController {

	static Logger logger = LoggerFactory.getLogger(SubscribersController.class);
	
	@Autowired
	SubscriberRepository subscriberRepository;
	
	@Autowired
	DndRepository dndRepository;


	@PreAuthorize("hasPermission('Subscribers','view')")
	@GetMapping("/subscribers")
	String getAllSubscribers(Model model) {
		model.addAttribute("allSubscribers", subscriberRepository.findAll());
		return "subscribers/list";
	}

	@PreAuthorize("hasPermission('Subscribers','edit')")
	@GetMapping("/subscribers/add")
	String getCreatePage(Model model) {
		model.addAttribute("subscriber", new Subscriber());
		model.addAttribute("allDnds", dndRepository.findAll());
		return "subscribers/edit";
	}

	@PreAuthorize("hasPermission('Subscribers','edit')")
	@GetMapping("/subscribers/edit/{subscriberID}")
	String getEditPage(Model model, @PathVariable long subscriberID) {
		model.addAttribute("subscriber", subscriberRepository.findById(subscriberID).get());
		model.addAttribute("allDnds", dndRepository.findAll());
		return "subscribers/edit";
	}

	@PreAuthorize("hasPermission('Subscribers','edit')")
	@PostMapping("/subscribers/save")
	String saveChannel(Model model, @ModelAttribute Subscriber subscriber, RedirectAttributes redirectAttributes) {
		if(subscriber.getId() != null && (subscriber.getPassword() == null || subscriber.getPassword().length() == 0)) {
			Subscriber oldSubscriber = subscriberRepository.findById(subscriber.getId()).get();
			subscriber.setPassword(oldSubscriber.getPassword());
		}
		subscriberRepository.save(subscriber);
		
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("subscribers.crud.save.flash.success", "success"));
		return "redirect:/subscribers";
	}

	@PreAuthorize("hasPermission('Subscribers','edit')")
	@GetMapping(value = "/subscribers/delete/{subscriberID}")
	public String deleteChannel(@PathVariable long subscriberID, RedirectAttributes redirectAttributes) {
		Optional<Subscriber> subscriber = subscriberRepository.findById(subscriberID);
			subscriberRepository.delete(subscriber.get());
			redirectAttributes.addFlashAttribute("flash", new LocalFlash("subscribers.crud.delete.flash.success", "success"));

		return "redirect:/subscribers";
	}

}