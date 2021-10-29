package com.code2.onlineshop.service;

import com.code2.onlineshop.entity.ShoppingCart;

public interface ShoppingCartService {

	public void saveCart(ShoppingCart cart);
	public void clearCartItem(String username);
	
}
