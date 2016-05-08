package com.bishe.photo.dao;

import com.bishe.photo.annotation.MyAnnotation;
import com.bishe.photo.entity.Comment;

@MyAnnotation
public interface CommentDao {
	
	public Integer saveComment(Comment comment);
	
	public void deleteComment(Integer id);
	
	public Comment findById(Integer id);
}
