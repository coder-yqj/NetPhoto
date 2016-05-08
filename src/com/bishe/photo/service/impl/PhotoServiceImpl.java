package com.bishe.photo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.photo.dao.PhotoDao;
import com.bishe.photo.entity.Photo;
import com.bishe.photo.service.PhotoService;

@Service("PhotoService")
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoDao photoDao;
	
	@Override
	public Integer save(Photo photo) {
		 photoDao.save(photo);
		 System.out.println("saveId:"+photo.getId());
		 return photo.getId();
	}

	@Override
	public List<Photo> findAll(Integer belongId) {
		return photoDao.findAll(belongId);
	}

	@Override
	public Photo findById(Integer id) {
		return photoDao.findById(id);
	}

	@Override
	public void delete(Integer id) {
		photoDao.delete(id);
	}

}
