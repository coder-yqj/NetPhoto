package com.bishe.photo.dao;

import com.bishe.photo.annotation.MyAnnotation;
import com.bishe.photo.entity.Vote;
@MyAnnotation
public interface VoteDao {
	
	public void saveVote(Vote vote);
	
	public Double findAvgVote(Integer photoId);
}
