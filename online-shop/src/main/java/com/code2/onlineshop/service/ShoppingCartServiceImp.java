package com.code2.onlineshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code2.onlineshop.entity.AppUser;
import com.code2.onlineshop.entity.CartItem;
import com.code2.onlineshop.entity.ShoppingCart;
import com.code2.onlineshop.repository.AppUserRepository;
import com.code2.onlineshop.repository.CartItemRepository;
import com.code2.onlineshop.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Override
	@Transactional
	public void saveCart(ShoppingCart cart) {
	   shoppingCartRepository.save(cart);
	}

	@Override
	@Transactional
	public void clearCartItem(String username) {
		AppUser user = appUserRepository.findByUsername(username);
		ShoppingCart cart = user.getShoppingCart();
		List<CartItem> cartItems = cart.getCartItems();
		for(CartItem item:cartItems) {
			cartItemRepository.delete(item);
		}
	}
}
