package com.code2.adminportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.code2.adminportal.entity.Product;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String showHome(Model model) {
		
		Product p = new Product(1l,"Book",500);
		
		model.addAttribute("title","Welcome to Admin Page");
		model.addAttribute("product",p);
		
		return "home";
	}
	
}
