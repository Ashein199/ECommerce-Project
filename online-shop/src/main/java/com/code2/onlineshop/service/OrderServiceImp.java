package com.code2.onlineshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code2.onlineshop.entity.AppUser;
import com.code2.onlineshop.entity.CartItem;
import com.code2.onlineshop.entity.Order;
import com.code2.onlineshop.entity.OrderItem;
import com.code2.onlineshop.entity.ShoppingCart;
import com.code2.onlineshop.repository.OrderItemRepository;
import com.code2.onlineshop.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	@Transactional
	public void createOrder(String name, String address) {
		AppUser user = appUserService.getAppUser(name);
		   ShoppingCart cart = user.getShoppingCart();
		   List<CartItem> cartItems = cart.getCartItems();
		   List<OrderItem> orderItems = new ArrayList<>();
		   Order order = new Order();
		   order.setUser(user);
		   order.setAddress(address);
		   
		   for(CartItem item:cartItems) {
			   OrderItem orderItem = new OrderItem();
			   orderItem.setOrder(order);
			   orderItem.setProduct(item.getProduct());
			   orderItem.setQuantity(item.getQuantity());
			   orderItem.setSubtotal(item.getSubtotal());
			   orderItemRepository.save(orderItem);
			   orderItems.add(orderItem);
		   }
		   
		   order.setTotal(cart.getTotal());
		   order.setOrderItems(orderItems);
		orderRepository.save(order);
	}

}
