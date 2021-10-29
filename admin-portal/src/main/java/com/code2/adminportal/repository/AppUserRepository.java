package com.code2.adminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code2.adminportal.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findByUsername(String username);
}
