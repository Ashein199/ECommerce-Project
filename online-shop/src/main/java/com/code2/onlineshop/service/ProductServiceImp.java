package com.code2.onlineshop.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.code2.onlineshop.entity.Product;
import com.code2.onlineshop.repository.ProductRepository;


@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public Page<Product> getProducts(Pageable pageable) {
		
		return productRepository.findAll(pageable);
		 
	}
	
	@Override
	@Transactional
	public void createOrupdateProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	@Transactional
	public Product getProduct(Long id) {
		
		return productRepository.getOne(id);
	}

	
	@Override
	@Transactional
	public List<Product> getProducts() {
		
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public Product getProductById(Long id) {
		
		return productRepository.getOne(id);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}

	

	

}
