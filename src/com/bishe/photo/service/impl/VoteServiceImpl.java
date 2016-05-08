package com.bishe.photo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.photo.dao.VoteDao;
import com.bishe.photo.entity.Vote;
import com.bishe.photo.service.VoteService;

@Service("voteService")
public class VoteServiceImpl implements VoteService{

	@Autowired
	private VoteDao voteDao;
	
	@Override
	public void addVote(Vote vote) {
		voteDao.saveVote(vote);
	}

}
