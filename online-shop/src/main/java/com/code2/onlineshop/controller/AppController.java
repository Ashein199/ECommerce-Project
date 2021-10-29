package com.code2.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.code2.onlineshop.entity.Category;
import com.code2.onlineshop.entity.Product;
import com.code2.onlineshop.service.CategoryService;
import com.code2.onlineshop.service.ProductService;

@Controller
public class AppController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String showHome(Model model) {
		Pageable pageable = PageRequest.of(0, 9);
		Page<Product> products = productService.getProducts(pageable);
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("products",products);
		model.addAttribute("categories",categories);
		return "home";
	}
}
