package com.weenko.pbx.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weenko.pbx.dao.RoleRepository;
import com.weenko.pbx.dao.UserRepository;
import com.weenko.pbx.gui.LocalFlash;
import com.weenko.pbx.model.Role;
import com.weenko.pbx.model.User;
import com.weenko.pbx.security.CustomPasswordEncoder;

@Controller
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	CustomPasswordEncoder customPasswordEncoder;
	
	@ModelAttribute("user")
	User getNewUser() {
		return new User();
	}
	
	@ModelAttribute("allRoles")
	Iterable<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	
	@ModelAttribute("allUsers")
	Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PreAuthorize("hasPermission('User','view')")
	@GetMapping("/admin/users")
	String getAllUsers(Model model) {
		return "admin/users/list";
	}

	@PreAuthorize("hasPermission('User','edit')")
	@GetMapping("/admin/users/create")
	String getCreatePage(Model model) {
		return "admin/users/create";
	}

	@PreAuthorize("hasPermission('User','edit')")
	@GetMapping("/admin/users/edit/{userID}")
	String getEditPage(Model model, @PathVariable long userID) {
		model.addAttribute("user", userRepository.findById(userID).get());
		return "admin/users/edit";
	}
	
	@PreAuthorize("hasPermission('User','edit')")
	@GetMapping(value = "/admin/users/delete/{userID}")
	public String deleteUser(@PathVariable long userID, RedirectAttributes redirectAttributes) {
		userRepository.deleteById(userID);
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("admin.users.delete.flash.success", "success"));

		return "redirect:/admin/users"; 
	}

	@PreAuthorize("hasPermission('User','edit')")
	@PostMapping("/admin/users/create")
	String saveNewUser(Model model, @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "admin/users/create";
		}
		
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			model.addAttribute("flash", new LocalFlash("admin.users.create.flash.duplicate", "error"));
			return "admin/users/create";
		}
		
		if(user.getPasswordStr() == null || user.getPasswordStr().length() == 0) {
			model.addAttribute("flash", new LocalFlash("admin.users.create.flash.empty_password", "error"));
			return "admin/users/create";
		}

		user.setPassword(customPasswordEncoder.encode(user.getPasswordStr()));

		userRepository.save(user);
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("admin.users.create.flash.success", "success"));
		return "redirect:/admin/users";
	}
	
	@PreAuthorize("hasPermission('User','edit')")
	@PostMapping("/admin/users/edit/{userID}")
	String saveUser(Model model, @PathVariable long userID, @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "admin/users/edit";
		}
			
		if (user.getPasswordStr()!= null && user.getPasswordStr().length() > 0)
			user.setPassword(customPasswordEncoder.encode(user.getPasswordStr()));
		else
			user.setPassword(userRepository.findById(user.getId()).get().getPassword());

		
		userRepository.save(user);
		redirectAttributes.addFlashAttribute("flash", new LocalFlash("admin.users.save.flash.success", "success"));
		
		if(user.getPassword() == null || user.getPassword().length() == 0)
			logger.info("Empty password!");
		return "redirect:/admin/users";
	}

}
