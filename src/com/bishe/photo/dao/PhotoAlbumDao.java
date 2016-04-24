package com.bishe.photo.dao;

import java.util.List;

import com.bishe.photo.annotation.MyAnnotation;
import com.bishe.photo.entity.PhotoAlbum;

@MyAnnotation
public interface PhotoAlbumDao {
	
	public void saveAlbum(PhotoAlbum photoAlbum);
	
	public List<PhotoAlbum> findAll(Integer userId);
	
	public void deleteByUserId(Integer userId);
	
	public void update(PhotoAlbum photoAlbum);
}
