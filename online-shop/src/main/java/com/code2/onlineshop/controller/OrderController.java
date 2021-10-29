package com.code2.onlineshop.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code2.onlineshop.service.OrderService;
import com.code2.onlineshop.service.ShoppingCartService;

@Controller
public class OrderController {
	 
	 @Autowired
	 private OrderService orderService;
	 
	 @Autowired
	 private ShoppingCartService shoppingCartService;

	   @GetMapping("/checkout")
	   public String showCheckOut() {
		   return "shoppingcart/chectout";
	   }
	   
	   @PostMapping("/checkout")
	   public String processCheckOut(@RequestParam("address") String address,Principal principal) {
		   String name= principal.getName();
		   orderService.createOrder(name,address);
		   shoppingCartService.clearCartItem(name);
		   return "redirect:/";
	   }
}

