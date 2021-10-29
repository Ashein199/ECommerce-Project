package com.code2.adminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.adminportal.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
