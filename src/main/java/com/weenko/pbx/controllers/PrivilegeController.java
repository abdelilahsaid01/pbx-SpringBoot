package com.weenko.pbx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.weenko.pbx.dao.PrivilegeRepository;
import com.weenko.pbx.security.CustomPasswordEncoder;

@Controller
public class PrivilegeController {

	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@Autowired
	CustomPasswordEncoder customPasswordEncoder;
	
	@PreAuthorize("hasPermission('Privileges','view')")
	@GetMapping("/admin/privileges")
    String getAllPrivileges(Model model) {
		model.addAttribute("allPrivileges", privilegeRepository.findAll());
        return "admin/privileges/list";
    }

}