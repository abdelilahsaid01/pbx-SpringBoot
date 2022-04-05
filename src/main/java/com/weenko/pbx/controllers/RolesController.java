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

import com.weenko.pbx.dao.PrivilegeRepository;
import com.weenko.pbx.dao.RoleRepository;
import com.weenko.pbx.gui.LocalFlash;
import com.weenko.pbx.model.Role;
import com.weenko.pbx.security.CustomPasswordEncoder;

@Controller
public class RolesController {

	static Logger logger = LoggerFactory.getLogger(RolesController.class);

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PrivilegeRepository privilegeRepository;

	@Autowired
	CustomPasswordEncoder customPasswordEncoder;

	@PreAuthorize("hasPermission('Roles','view')")
	@GetMapping("/admin/roles")
	String getAllRoles(Model model) {
		model.addAttribute("allRoles", roleRepository.findAll());
		return "admin/roles/list";
	}

	@PreAuthorize("hasPermission('Roles','edit')")
	@GetMapping("/admin/roles/add")
	String getCreatePage(Model model) {
		model.addAttribute("role", new Role());
		model.addAttribute("allPrivileges", privilegeRepository.findAll());
		return "admin/roles/edit";
	}

	@PreAuthorize("hasPermission('Roles','edit')")
	@GetMapping("/admin/roles/edit/{roleID}")
	String getEditPage(Model model, @PathVariable long roleID) {
		model.addAttribute("role", roleRepository.findById(roleID).get());
		model.addAttribute("allPrivileges", privilegeRepository.findAll());
		return "admin/roles/edit";
	}

	@PreAuthorize("hasPermission('Roles','edit')")
	@PostMapping("/admin/roles/save")
	String saveRole(Model model, @ModelAttribute Role role, RedirectAttributes redirectAttributes) {
		roleRepository.save(role);
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("admin.roles.save.flash.success", "success"));
		return "redirect:/admin/roles";
	}

	@PreAuthorize("hasPermission('Roles','edit')")
	@GetMapping(value = "/admin/roles/delete/{roleID}")
	public String deleteRole(@PathVariable long roleID, RedirectAttributes redirectAttributes) {
		Optional<Role> role = roleRepository.findById(roleID);
		if (role.get().getUsers().size() > 0) {
			redirectAttributes.addFlashAttribute("flash", new LocalFlash("admin.roles.delete.flash.busy", "error",
					role.get().getUsers().iterator().next().toString()));
		} else {
			roleRepository.delete(role.get());
			redirectAttributes.addFlashAttribute("flash",
					new LocalFlash("admin.roles.delete.flash.success", "success"));
		}

		return "redirect:/admin/roles";
	}

}