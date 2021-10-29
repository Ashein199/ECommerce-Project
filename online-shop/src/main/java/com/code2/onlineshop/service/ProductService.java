package com.code2.onlineshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.code2.onlineshop.entity.Product;

public interface ProductService {
	
	public void createOrupdateProduct(Product product);

	public Page<Product> getProducts(Pageable pageable);

	public Product getProduct(Long id);
	
	public void deleteProduct(Long id);

	public List<Product> getProducts();

	public Product getProductById(Long id);

}
