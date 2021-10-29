package com.code2.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.onlineshop.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public com.code2.onlineshop.entity.AppUser findByUsername(String username);
}
