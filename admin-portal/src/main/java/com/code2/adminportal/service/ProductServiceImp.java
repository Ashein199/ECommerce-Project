package com.code2.adminportal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.code2.adminportal.entity.Product;
import com.code2.adminportal.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public void createOrupdateProduct(Product product) {
		productRepository.save(product);
	}
	
	
	@Override
	@Transactional
	public Page<Product> getProducts(Pageable pageable){
		
	    return productRepository.findAll(pageable);
	    
	}


	@Override
	@Transactional
	public Product getProduct(Long id) {
		return productRepository.getOne(id);
	}


	@Override
	@Transactional
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
