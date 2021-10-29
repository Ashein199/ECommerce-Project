package com.code2.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.onlineshop.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
