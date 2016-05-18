package com.bishe.photo.dao;

import java.util.List;
import java.util.Map;

import com.bishe.photo.annotation.MyAnnotation;
import com.bishe.photo.entity.PhotoAlbum;

@MyAnnotation
public interface PhotoAlbumDao {
	
	public void saveAlbum(PhotoAlbum photoAlbum);
	
	public List<PhotoAlbum> findAll(Integer userId);
	
	public void deleteByUserId(Integer userId);
	
	public void update(PhotoAlbum photoAlbum);
	
	public PhotoAlbum findById(Integer id);
	
	public void updateCover(Map<String, Object> map);
	
	public List<PhotoAlbum> findAllUserAlbum(Integer userId);
}
