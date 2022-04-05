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

import com.weenko.pbx.dao.BwListRepository;
import com.weenko.pbx.dao.SubscriberRepository;
import com.weenko.pbx.gui.LocalFlash;
import com.weenko.pbx.model.BwEntry;

@Controller
public class BwEntriesController {

	static Logger logger = LoggerFactory.getLogger(BwEntriesController.class);

	@Autowired
	SubscriberRepository subscriberRepository;
	
	@Autowired
	BwListRepository bwListRepository;


	@PreAuthorize("hasPermission('BwEntries','view')")
	@GetMapping("/bwentries")
	String getAllEntries(Model model) {
		model.addAttribute("allEntries", bwListRepository.findAll());
		return "bwentries/list";
	}

	@PreAuthorize("hasPermission('BwEntries','edit')")
	@GetMapping("/bwentries/add")
	String getCreatePage(Model model) {
		model.addAttribute("entry", new BwEntry());
		model.addAttribute("allSubscribers", subscriberRepository.findAll());
		return "bwentries/edit";
	}

	@PreAuthorize("hasPermission('BwEntries','edit')")
	@GetMapping("/bwentries/edit/{entryID}")
	String getEditPage(Model model, @PathVariable long entryID) {
		model.addAttribute("entry", bwListRepository.findById(entryID).get());
		model.addAttribute("allSubscribers", subscriberRepository.findAll());
		return "bwentries/edit";
	}

	@PreAuthorize("hasPermission('BwEntries','edit')")
	@PostMapping("/bwentries/save")
	String saveEntry(Model model, @ModelAttribute BwEntry entry, RedirectAttributes redirectAttributes) {
		bwListRepository.save(entry);
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("bwentries.crud.save.flash.success", "success"));
		return "redirect:/bwentries";
	}

	@PreAuthorize("hasPermission('BwEntries','edit')")
	@GetMapping(value = "/bwentries/delete/{entryID}")
	public String deleteEntry(@PathVariable long entryID, RedirectAttributes redirectAttributes) {
		Optional<BwEntry> entry = bwListRepository.findById(entryID);
		bwListRepository.delete(entry.get());
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("bwentries.crud.delete.flash.success", "success"));

		return "redirect:/bwentries";
	}

}