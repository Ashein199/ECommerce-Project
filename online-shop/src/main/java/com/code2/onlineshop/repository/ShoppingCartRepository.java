package com.code2.onlineshop.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.code2.onlineshop.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepositoryImplementation<ShoppingCart, Long>{

}
