package com.code2.onlineshop.service;

import com.code2.onlineshop.entity.AppUser;

public interface AppUserService {

	public void saveAppUser(AppUser user);

	public AppUser getAppUser(String username);

}
