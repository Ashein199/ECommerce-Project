package com.code2.onlineshop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.code2.onlineshop.entity.AppUser;
import com.code2.onlineshop.entity.Role;
import com.code2.onlineshop.entity.ShoppingCart;
import com.code2.onlineshop.repository.AppUserRepository;
import com.code2.onlineshop.repository.ShoppingCartRepository;

@Service
public class AppUserServiceImp implements AppUserService{
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void saveAppUser(AppUser user) {
		String password = user.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		
		user.setPassword(encodedPassword);
		user.addRole(new Role(2l,"CUSTOMER"));
		ShoppingCart cart=new ShoppingCart();
		shoppingCartRepository.save(cart);
		
		user.setShoppingCart(cart);
		appUserRepository.save(user);
	}

	@Override
	public AppUser getAppUser(String username) {

		return appUserRepository.findByUsername(username);
	}
	
	

}
