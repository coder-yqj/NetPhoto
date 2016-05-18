package com.bishe.photo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bishe.photo.dao.UserDao;
import com.bishe.photo.entity.User;
import com.bishe.photo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;

	
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
		
	}


	@Override
	public User findByName(String userName) {
		return userDao.findByName(userName);
	}


	@Override
	public void updatePassword(User user) {
		userDao.updatePassword(user);
	}

	
	
}
