package com.code2.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code2.onlineshop.entity.CartItem;
import com.code2.onlineshop.repository.CartItemRepository;

@Service
public class CartItemServiceImp implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public void saveCartItem(CartItem item) {
	    cartItemRepository.save(item);
	}
}
