package com.code2.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.onlineshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
