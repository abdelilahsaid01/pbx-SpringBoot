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

import com.weenko.pbx.dao.RechargeRepository;
import com.weenko.pbx.gui.LocalFlash;
import com.weenko.pbx.model.Recharge;

@Controller
public class RechargesController {

	static Logger logger = LoggerFactory.getLogger(RechargesController.class);
	
	@Autowired
	RechargeRepository rechargeRepository;


	@PreAuthorize("hasPermission('Recharges','view')")
	@GetMapping("/recharges")
	String getAllRecharges(Model model) {
		model.addAttribute("allRecharges", rechargeRepository.findAll());
		return "recharges/list";
	}

	@PreAuthorize("hasPermission('Recharges','edit')")
	@GetMapping("/recharges/add")
	String getCreatePage(Model model) {
		model.addAttribute("recharge", new Recharge());
		return "recharges/edit";
	}

	@PreAuthorize("hasPermission('Recharges','edit')")
	@GetMapping("/recharges/edit/{rechargeID}")
	String getEditPage(Model model, @PathVariable long rechargeID) {
		model.addAttribute("recharge", rechargeRepository.findById(rechargeID).get());
		return "recharges/edit";
	}

	@PreAuthorize("hasPermission('Recharges','edit')")
	@PostMapping("/recharges/save")
	String saveRecharge(Model model, @ModelAttribute Recharge recharge, RedirectAttributes redirectAttributes) {
		rechargeRepository.save(recharge);
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("recharges.crud.save.flash.success", "success"));
		return "redirect:/recharges";
	}

	@PreAuthorize("hasPermission('Recharges','edit')")
	@GetMapping(value = "/recharges/delete/{rechargeID}")
	public String deleteRecharge(@PathVariable long rechargeID, RedirectAttributes redirectAttributes) {
		Optional<Recharge> recharge = rechargeRepository.findById(rechargeID);
			rechargeRepository.delete(recharge.get());
			redirectAttributes.addFlashAttribute("flash", new LocalFlash("recharges.crud.delete.flash.success", "success"));

		return "redirect:/recharges";
	}

}