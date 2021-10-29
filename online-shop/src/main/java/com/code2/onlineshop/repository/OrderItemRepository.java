package com.code2.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.onlineshop.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
