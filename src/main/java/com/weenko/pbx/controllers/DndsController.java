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
import com.weenko.pbx.gui.LocalFlash;
import com.weenko.pbx.model.Dnd;

@Controller
public class DndsController {

	static Logger logger = LoggerFactory.getLogger(DndsController.class);
	
	@Autowired
	DndRepository dndRepository;


	@PreAuthorize("hasPermission('Dnds','view')")
	@GetMapping("/dnds")
	String getAllDnds(Model model) {
		model.addAttribute("allDnds", dndRepository.findAll());
		return "dnds/list";
	}

	@PreAuthorize("hasPermission('Dnds','edit')")
	@GetMapping("/dnds/add")
	String getCreatePage(Model model) {
		model.addAttribute("dnd", new Dnd());
		return "dnds/edit";
	}

	@PreAuthorize("hasPermission('Dnds','edit')")
	@GetMapping("/dnds/edit/{dndID}")
	String getEditPage(Model model, @PathVariable long dndID) {
		model.addAttribute("dnd", dndRepository.findById(dndID).get());
		return "dnds/edit";
	}

	@PreAuthorize("hasPermission('Dnds','edit')")
	@PostMapping("/dnds/save")
	String saveDnd(Model model, @ModelAttribute Dnd dnd, RedirectAttributes redirectAttributes) {
		dndRepository.save(dnd);
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("dnd.crud.save.flash.success", "success"));
		return "redirect:/dnds";
	}

	@PreAuthorize("hasPermission('Dnds','edit')")
	@GetMapping(value = "/dnds/delete/{dndID}")
	public String deleteDnd(@PathVariable long dndID, RedirectAttributes redirectAttributes) {
		Optional<Dnd> dnd = dndRepository.findById(dndID);
			dndRepository.delete(dnd.get());
			redirectAttributes.addFlashAttribute("flash", new LocalFlash("dnd.crud.delete.flash.success", "success"));

		return "redirect:/dnds";
	}

}