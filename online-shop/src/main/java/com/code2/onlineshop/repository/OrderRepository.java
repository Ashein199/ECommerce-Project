package com.code2.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.onlineshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
