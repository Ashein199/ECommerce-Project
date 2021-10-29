package com.code2.onlineshop.service;

import java.util.List;

import com.code2.onlineshop.entity.Category;

public interface CategoryService {
	
	public List<Category> getCategories();
	public Category getCategory(Long id);

}
