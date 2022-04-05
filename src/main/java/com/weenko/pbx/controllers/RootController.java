package com.weenko.pbx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weenko.pbx.dao.ChannelRepository;
import com.weenko.pbx.dao.PrivilegeRepository;
import com.weenko.pbx.dao.PsAorRepository;
import com.weenko.pbx.dao.PsAuthRepository;
import com.weenko.pbx.dao.PsEndpointRepository;
import com.weenko.pbx.dao.RechargeRepository;
import com.weenko.pbx.dao.RoleRepository;
import com.weenko.pbx.dao.SubscriberRepository;
import com.weenko.pbx.dao.UserRepository;
import com.weenko.pbx.model.Privilege;
import com.weenko.pbx.model.PsAor;
import com.weenko.pbx.model.PsAuth;
import com.weenko.pbx.model.PsEndpoint;
import com.weenko.pbx.model.Role;
import com.weenko.pbx.security.CustomPasswordEncoder;

@Controller
public class RootController {
	
	@Autowired
	SubscriberRepository subscriberRepository;
	
	@Autowired
	ChannelRepository channelRepository;
	
	@Autowired
	RechargeRepository rechargeRepository;
	
	@GetMapping("/login")
	String getLoginPage(Model model, @RequestParam(required = false) boolean error) {
		if(error)
			model.addAttribute("error", true);
		return "login";
	}

	@GetMapping("/home")
	String getHomePage(Model model) {
		model.addAttribute("subscribers", subscriberRepository.count());
		model.addAttribute("channels", channelRepository.count());
		model.addAttribute("activeRecharges", rechargeRepository.countByActive(true));
		model.addAttribute("totRecharges", subscriberRepository.count());
		
		return "home";
	}
	
	@GetMapping("/")
	String getRootPage(Model model) {
		model.addAttribute("subscribers", subscriberRepository.count());
		model.addAttribute("channels", channelRepository.count());
		model.addAttribute("activeRecharges", rechargeRepository.countByActive(true));
		model.addAttribute("totRecharges", subscriberRepository.count());
		
		return "home";
	}
	
	@GetMapping("/fonts")
	String getAvailableFonts(Model model) {
		return "fonts";
	}
	
	@GetMapping("/ps_aors")
	@ResponseBody
	Iterable<PsAor> getAvailableAors(Model model) {
		return psAorsRepository.findAll();
	}
	
	@GetMapping("/ps_auths")
	@ResponseBody
	Iterable<PsAuth> getAvailableAuths(Model model) {
		return psAuthsRepository.findAll();
	}
	
	@GetMapping("/ps_endpoints")
	@ResponseBody
	Iterable<PsEndpoint> getAvailableEndpoints(Model model) {
		return psEndpointsRepository.findAll();
	}
	
	@Autowired
	PsAorRepository psAorsRepository;
	
	@Autowired
	PsAuthRepository psAuthsRepository;
	
	@Autowired
	PsEndpointRepository psEndpointsRepository;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	CustomPasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	
	@GetMapping("/maintenance")
	String getMaintenancePage(Model model) {
		return "maintenance";
	}
	
	// Development only
	@GetMapping("/test")
	String createAdminUser(Model model) {
		
		Privilege viewPrivilege = new Privilege();
		Privilege editPrivilege = new Privilege();
//		privilege.setCode("USER_EDIT");
//		privilege.setName("USER_EDIT");
		
//		privilege.setCode("USER_VIEW");
//		privilege.setName("USER_VIEW");
		
//		privilege.setCode("ROLE_VIEW");
//		privilege.setName("ROLE_VIEW");
		
//		privilege.setCode("ROLE_EDIT");
//		privilege.setName("ROLE_EDIT");
		
//		privilege.setCode("PRIVILEGE_VIEW");
//		privilege.setName("PRIVILEGE_VIEW");
		
//		privilege.setCode("BWLIST_VIEW");
//		privilege.setName("BWLIST_VIEW");
		
//		privilege.setCode("BWLIST_EDIT");
//		privilege.setName("BWLIST_EDIT");
		
//		viewPrivilege.setCode("CHANNELS_VIEW");
//		viewPrivilege.setName("CHANNELS_VIEW");
		
//		editPrivilege.setCode("CHANNELS_EDIT");
//		editPrivilege.setName("CHANNELS_EDIT");
		
//		viewPrivilege.setCode("SUBSCRIBERS_VIEW");
//		viewPrivilege.setName("SUBSCRIBERS_VIEW");
//		
//		editPrivilege.setCode("SUBSCRIBERS_EDIT");
//		editPrivilege.setName("SUBSCRIBERS_EDIT");
		
//		viewPrivilege.setCode("DESTINATIONS_VIEW");
//		viewPrivilege.setName("DESTINATIONS_VIEW");
//		
//		editPrivilege.setCode("DESTINATIONS_EDIT");
//		editPrivilege.setName("DESTINATIONS_EDIT");
		
//		viewPrivilege.setCode("RECHARGES_VIEW");
//		viewPrivilege.setName("RECHARGES_VIEW");
//		
//		editPrivilege.setCode("RECHARGES_EDIT");
//		editPrivilege.setName("RECHARGES_EDIT");
		
//		viewPrivilege.setCode("CDRS_VIEW");
//		viewPrivilege.setName("CDRS_VIEW");
//		
//		editPrivilege.setCode("CDRS_EDIT");
//		editPrivilege.setName("CDRS_EDIT");
		
//		viewPrivilege.setCode("DNDS_VIEW");
//		viewPrivilege.setName("DNDS_VIEW");
//		
//		editPrivilege.setCode("DNDS_EDIT");
//		editPrivilege.setName("DNDS_EDIT");
		
		viewPrivilege.setCode("PARAMETERS_VIEW");
		viewPrivilege.setName("PARAMETERS_VIEW");
		
		editPrivilege.setCode("PARAMETERS_EDIT");
		editPrivilege.setName("PARAMETERS_EDIT");
		
		privilegeRepository.save(viewPrivilege);
		privilegeRepository.save(editPrivilege);
		
		Role role = roleRepository.findById(5L).get();
//		Role role = new Role();
		//role.setName("admin");
		role.getPrivileges().add(viewPrivilege);
		role.getPrivileges().add(editPrivilege);
		roleRepository.save(role);
		
//		User user = new User();
//		User user = userRepository.findByUsername("admin").get();
//		user.setFirstName("admin");
//		user.setLastName("admin");
//		user.setUsername("admin");
//		user.setPassword(passwordEncoder.encode("admin"));
//		
//		user.setRoles(roles_set);
//		
//		userRepository.save(user);
		return "login";
	}
}