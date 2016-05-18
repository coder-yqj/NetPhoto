package com.bishe.photo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.photo.domain.Message;
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
	@ResponseBody
	@RequestMapping("/updatePassword")
	public Message updatePassword(String oldPassword,String newPassword,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		User findUser = userService.findByName(user.getUserName());
		if(oldPassword.equals(findUser.getPassword())){
			findUser.setPassword(newPassword);
			userService.updatePassword(findUser);
			return new Message("1", "更改密码成功");
		}else{
			return new Message("0", "更改密码失败");
		}
	}
	
}	
