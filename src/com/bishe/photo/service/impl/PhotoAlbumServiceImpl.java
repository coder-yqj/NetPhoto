package com.bishe.photo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishe.photo.dao.PhotoAlbumDao;
import com.bishe.photo.entity.PhotoAlbum;
import com.bishe.photo.service.PhotoAlbumService;

@Service("photoAlbumService")
public class PhotoAlbumServiceImpl implements PhotoAlbumService {
	
	@Autowired
	private PhotoAlbumDao photoAlbumDao;
	
	
	@Override
	public void saveAlbum(PhotoAlbum photoAlbum) {
		photoAlbumDao.saveAlbum(photoAlbum);
	}


	@Override
	public List<PhotoAlbum> findAll(Integer userId) {
		return photoAlbumDao.findAll(userId);
	}


	@Override
	public void delete(Integer id) {
		photoAlbumDao.deleteByUserId(id);
	}


	@Override
	public void update(PhotoAlbum photoAlbum) {
		photoAlbumDao.update(photoAlbum);
	}
	
	

}
