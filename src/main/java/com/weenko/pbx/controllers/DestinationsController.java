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

import com.weenko.pbx.dao.DestinationRepository;
import com.weenko.pbx.gui.LocalFlash;
import com.weenko.pbx.model.Destination;

@Controller
public class DestinationsController {

	static Logger logger = LoggerFactory.getLogger(DestinationsController.class);
	
	@Autowired
	DestinationRepository destinationRepository;


	@PreAuthorize("hasPermission('Destinations','view')")
	@GetMapping("/destinations")
	String getAllDestinations(Model model) {
		model.addAttribute("allDestinations", destinationRepository.findAll());
		return "destinations/list";
	}

	@PreAuthorize("hasPermission('Destinations','edit')")
	@GetMapping("/destinations/add")
	String getCreatePage(Model model) {
		model.addAttribute("destination", new Destination());
		return "destinations/edit";
	}

	@PreAuthorize("hasPermission('Destinations','edit')")
	@GetMapping("/destinations/edit/{destinationID}")
	String getEditPage(Model model, @PathVariable long destinationID) {
		model.addAttribute("destination", destinationRepository.findById(destinationID).get());
		return "destinations/edit";
	}

	@PreAuthorize("hasPermission('Destinations','edit')")
	@PostMapping("/destinations/save")
	String saveDestination(Model model, @ModelAttribute Destination destination, RedirectAttributes redirectAttributes) {
		destinationRepository.save(destination);
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("destinations.crud.save.flash.success", "success"));
		return "redirect:/destinations";
	}

	@PreAuthorize("hasPermission('Destinations','edit')")
	@GetMapping(value = "/destinations/delete/{destinationID}")
	public String deleteDestination(@PathVariable long destinationID, RedirectAttributes redirectAttributes) {
		Optional<Destination> destination = destinationRepository.findById(destinationID);
			destinationRepository.delete(destination.get());
			redirectAttributes.addFlashAttribute("flash", new LocalFlash("destinations.crud.delete.flash.success", "success"));
		return "redirect:/destinations";
	}

}