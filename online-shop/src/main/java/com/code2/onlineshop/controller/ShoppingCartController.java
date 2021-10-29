package com.code2.onlineshop.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code2.onlineshop.entity.AppUser;
import com.code2.onlineshop.entity.CartItem;
import com.code2.onlineshop.entity.Product;
import com.code2.onlineshop.entity.ShoppingCart;
import com.code2.onlineshop.service.AppUserService;
import com.code2.onlineshop.service.CartItemService;
import com.code2.onlineshop.service.ProductService;
import com.code2.onlineshop.service.ShoppingCartService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@GetMapping("")
	public String showShoppingCart(Model model,Principal principal) {
		String username=principal.getName();
		AppUser user=appUserService.getAppUser(username);
		ShoppingCart cart=user.getShoppingCart();
		List<CartItem> items=cart.getCartItems();
		double total=0;
		for(CartItem item:items) {
			total+=item.getSubtotal();
			
		}
		cart.setTotal(total);
		shoppingCartService.saveCart(cart);
		
		model.addAttribute("cart",cart);
		model.addAttribute("items",items);
		
		return "shoppingcart/index";
		
	}
	
	@GetMapping("/add")
	public String addToCart(@RequestParam("id")Long id,Principal principal) {
		Product product=productService.getProductById(id);
		String username=principal.getName();
		
		System.out.println("Product"+product.getName());
		System.out.println("UserName"+username);
		
		AppUser user=appUserService.getAppUser(username);
		ShoppingCart cart=user.getShoppingCart();
		
		List<CartItem> items=cart.getCartItems();
		
		if(items==null) {
			System.out.println("Items List ma shi par");
		}else {
			
		
		for(CartItem item:items) {
			if(item.getProduct().getId()==product.getId()) {
				item.setQuantity(item.getQuantity()+1);
				item.setSubtotal(product.getPrice()*item.getQuantity());
				cartItemService.saveCartItem(item);
				return "redirect:";
			}
			
		}
		
		}
		System.out.println("continue....");
		CartItem item=new CartItem();
		item.setShoppingCart(cart);
		item.setProduct(product);
		item.setQuantity(1);
		item.setSubtotal(product.getPrice()*item.getQuantity());
		
		cartItemService.saveCartItem(item);
		return"redirect:";
	}

}
