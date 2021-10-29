package com.code2.adminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.adminportal.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
