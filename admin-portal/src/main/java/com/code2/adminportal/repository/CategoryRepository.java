package com.code2.adminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.adminportal.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
