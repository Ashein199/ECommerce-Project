package com.code2.adminportal.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.code2.adminportal.entity.AppUser;
import com.code2.adminportal.entity.Role;
import com.code2.adminportal.repository.AppUserRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService {
	
	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser appUser = appUserRepository.findByUsername(username);
		
		if(appUser!=null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			List<Role> roles = appUser.getRoles();
			for(Role role:roles) {
				authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
			}
			User user = new User(appUser.getUsername(),appUser.getPassword(),authorities);
			return user;
		}else {
			throw new UsernameNotFoundException("user not found");
		}
		
		
	}

}
