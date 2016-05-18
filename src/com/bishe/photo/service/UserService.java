package com.bishe.photo.service;

import com.bishe.photo.entity.User;

public interface UserService {
	
	public void saveUser(User user);
	
	public User findByName(String userName);
	
	public void updatePassword(User user);
}
