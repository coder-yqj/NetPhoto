package com.bishe.photo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.photo.domain.Message;
import com.bishe.photo.entity.User;
import com.bishe.photo.service.UserService;
@RequestMapping("/login")
@Controller
public class LoginController {
	static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private  UserService userService;
	
	@ResponseBody
	@RequestMapping("/login")
	public  Message login(String userName ,String password,HttpServletRequest request){
		User user = userService.findByName(userName);
		if(user!= null){
			if(user.getPassword().equals(password)){
				Message message = new Message("1","登录成功");
				logger.info("message:"+message);
				HttpSession session = request.getSession();
				logger.info("sessionId:"+session.getId());
				session.setAttribute("user", user);
				return message;
			}
		}
		Message message = new Message("0","账号或密码错误");
		System.out.println(message);
		return message;
		
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public Message register(String userName ,String password){
		User user = userService.findByName(userName);
		if(user == null){
			User addUser = new User(userName,password);
			userService.saveUser(addUser);
			return new Message("1","注册成功");
		}else{
			return new Message("0","用户名已存在");
		}
	}
	
}
