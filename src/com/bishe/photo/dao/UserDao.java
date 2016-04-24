package com.bishe.photo.dao;

import com.bishe.photo.annotation.MyAnnotation;
import com.bishe.photo.entity.User;
@MyAnnotation
public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 */
	public void saveUser(User user);
	
	/**
	 * 更加用户名查找用户
	 * @param name
	 */
	public User findByName(String userName);
	
}
