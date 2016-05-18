package com.bishe.photo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.photo.domain.Message;
import com.bishe.photo.entity.Comment;
import com.bishe.photo.entity.User;
import com.bishe.photo.service.CommentService;

@RequestMapping("/comment")
@Controller
public class CommentController {
		
	
	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@RequestMapping("/add")
	public Message addComment(Comment comment,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		comment.setUserId(user.getId());
		comment.setUserName(user.getUserName());;
		comment.setDate(new Timestamp(new Date().getTime()) );
		
		try {
			System.out.println("comment"+comment);
			Integer savedId = commentService.saveComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
			return new Message("0","评论失败");
		}
		
		return this.findById(comment.getId());
	}
	
	public Message findById(Integer id){
		List<Comment> comments = new ArrayList<Comment>();
		Comment comment = commentService.findById(id);
		comments.add(comment);
		return new Message("1",comments);
	}
	
	
	@ResponseBody
	@RequestMapping("/delete")
	public Message delComment(Integer id){
		try {
			commentService.deleteCommentById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message("0","删除失败");
		}
		return new Message("1","删除成功");
	}
	
}
