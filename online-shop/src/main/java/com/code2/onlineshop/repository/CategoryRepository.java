package com.code2.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.onlineshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
