package com.code2.adminportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/login")
	public String showLogin() {
		return "security/login";
	}
	
	@GetMapping("/register")
	public String showRegister() {
		return "security/register";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "security/access-denied";
	}
	
}
