package com.code2.adminportal.service;

import java.util.List;

import com.code2.adminportal.entity.Category;

public interface CategoryService {
	
	public List<Category> getCategories();
	public Category getCategory(Long id);

}
