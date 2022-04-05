package com.weenko.pbx.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.weenko.pbx.dao.CdrRepository;

@Controller
public class CdrsController {

	static Logger logger = LoggerFactory.getLogger(CdrsController.class);
	
	@Autowired
	CdrRepository cdrRepository;


	@PreAuthorize("hasPermission('Cdrs','view')")
	@GetMapping("/cdrs")
	String getAllCdrs(Model model) {
		model.addAttribute("allCdrs", cdrRepository.findAll());
		return "cdrs/list";
	}
	
	@PreAuthorize("hasPermission('Cdrs','view')")
	@GetMapping("/cdrs/view/{sequence}")
	String getCdr(Model model, @PathVariable long sequence) {
		model.addAttribute("cdr", cdrRepository.findById(sequence).get());
		return "cdrs/view";
	}

}