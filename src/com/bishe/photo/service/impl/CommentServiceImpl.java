package com.bishe.photo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.photo.dao.CommentDao;
import com.bishe.photo.entity.Comment;
import com.bishe.photo.service.CommentService;


@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	@Autowired(required=true)
	private CommentDao commentDao;
	
	
	@Override
	public Integer saveComment(Comment comment) {
		 commentDao.saveComment(comment);
		 return comment.getId();
	}


	@Override
	public void deleteCommentById(Integer id) {
		commentDao.deleteComment(id);
	}
	
	public Comment findById(Integer id){
		return commentDao.findById(id);
	}

	
}
