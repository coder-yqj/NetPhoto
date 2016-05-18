package com.bishe.photo.service.impl;

import java.util.HashMap;
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
	public Integer saveAlbum(PhotoAlbum photoAlbum) {
		photoAlbumDao.saveAlbum(photoAlbum);
		return photoAlbum.getId();
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


	@Override
	public PhotoAlbum findById(Integer id) {
		return photoAlbumDao.findById(id);
	}


	@Override
	public void updateCover(String url, Integer id) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("url", url);
		map.put("id", id);
		photoAlbumDao.updateCover(map);
	}


	@Override
	public List<PhotoAlbum> findAllUserAlbum(Integer userId) {
		return photoAlbumDao.findAllUserAlbum(userId);
	}
	
	

}
