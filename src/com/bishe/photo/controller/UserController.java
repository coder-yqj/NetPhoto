package com.bishe.photo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bishe.photo.entity.User;
import com.bishe.photo.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/saveUser")
	public String saveUser(User user,Model model){
		if(userService.findByName(user.getUserName())==null){
			userService.saveUser(user);
			model.addAttribute("user", user);
			return "user/success";
		}else{
			model.addAttribute("message", "用户名被占用");
			return "../register";
		}
		
	}
	
}	
