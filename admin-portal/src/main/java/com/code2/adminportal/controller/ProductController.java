package com.code2.adminportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.code2.adminportal.entity.Category;
import com.code2.adminportal.entity.Product;
import com.code2.adminportal.service.CategoryService;
import com.code2.adminportal.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public String showProducts(@RequestParam("page")int index,Model model) {
		
		Pageable pageable = PageRequest.of(index,5); // 15  5,5,5
		Page<Product> products = productService.getProducts(pageable);
		int totalPages = products.getTotalPages();
		
		System.out.println("Total Pages:"+totalPages);
		
		if(totalPages>0) {
			List<Integer> pageNumbers = new ArrayList<>();
			for(int i=1;i<=totalPages;i++) {
				pageNumbers.add(i);
			}
			model.addAttribute("pageNumbers",pageNumbers);
		}
		
		model.addAttribute("products", products);

		return "products/index";
	}

	@PostMapping("")
	public String createOrupdateProduct(@RequestParam("category") Long id,@ModelAttribute("product") Product product,RedirectAttributes redirectAttribute) {
		
		Category category = categoryService.getCategory(id);
		product.setCategory(category);
		productService.createOrupdateProduct(product);
		redirectAttribute.addAttribute("page",0);
		return "redirect:products";
	}

	@GetMapping("/new")
	public String showAddForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories",categories);
		return "products/new";
	}

	@GetMapping("/edit")
	public String showEditForm(@RequestParam("id") Long id, Model model) {
		Product product = productService.getProduct(id);
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories",categories);
		model.addAttribute("product", product);
		return "products/edit";
	}
	
	@GetMapping("/delete")
	public String showEditForm(@RequestParam("id") Long id,RedirectAttributes redirectAttribute) {
		productService.deleteProduct(id);
		redirectAttribute.addAttribute("page",0);
		return "redirect:";
	}

}
