package com.code2.adminportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code2.adminportal.entity.Order;
import com.code2.adminportal.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("")
    public String showOrders(Model model){
	   List<Order> orders =  orderService.getOrders();
	   model.addAttribute("orders",orders);
	   return "orders/index";
   }

}
