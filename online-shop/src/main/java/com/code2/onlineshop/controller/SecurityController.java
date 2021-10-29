package com.code2.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.code2.onlineshop.entity.AppUser;
import com.code2.onlineshop.service.AppUserService;

@Controller
public class SecurityController {
	
	@Autowired
	private AppUserService appUserService;
	
	@GetMapping("/login")
	public String showLogin() {
		return "security/login";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		AppUser user = new AppUser();
		model.addAttribute("user", user);
		return "security/register";
	}
	
	@PostMapping("/register")
	public String processRegister(@ModelAttribute("user")AppUser user) {

        appUserService.saveAppUser(user);
		return "redirect:/";
	}
}
