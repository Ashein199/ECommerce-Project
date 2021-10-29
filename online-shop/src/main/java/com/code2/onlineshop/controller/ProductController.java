package com.code2.onlineshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code2.onlineshop.entity.Category;
import com.code2.onlineshop.entity.Product;
import com.code2.onlineshop.service.CategoryService;
import com.code2.onlineshop.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public String showProducts(@RequestParam("page") int page, @RequestParam("cat") Long catId, Model model) {
		if (catId == 0) {
			Pageable pageable = PageRequest.of(page, 8);
			Page<Product> products = productService.getProducts(pageable);
			
			model.addAttribute("products", products);

		int totalPages = products.getTotalPages();

		System.out.println("Total Pages:" + totalPages);

		if (totalPages > 0) {
			List<Integer> pageNumbers = new ArrayList<>();				for (int i = 1; i <= totalPages; i++) {
					pageNumbers.add(i);
				}
		model.addAttribute("pageNumbers", pageNumbers);
			}
		}else {
			Category category = categoryService.getCategory(catId);
			List<Product> products = category.getProducts();
			int size = 8;
			int fromIndex = page*size;
			int toIndex = Math.min(fromIndex+5, products.size());

			List<Product> newList = products.subList(fromIndex, toIndex);
			Page<Product> productPage= new PageImpl<Product>(newList, PageRequest.of(page, size),products.size());
			model.addAttribute("products",productPage);
			int totalPages = productPage.getTotalPages();
			if (totalPages > 0) {
				List<Integer> pageNumbers = new ArrayList<>();				
				for (int i = 1; i <= totalPages; i++) {
						pageNumbers.add(i);
					}
		}
		}
		return "products/index";
	}

}

