package com.bishe.photo.service;

import com.bishe.photo.entity.Comment;

public interface CommentService {
	
	public Integer saveComment(Comment comment);
	
	public void deleteCommentById(Integer id);
	
	public Comment findById(Integer id);
	
}
