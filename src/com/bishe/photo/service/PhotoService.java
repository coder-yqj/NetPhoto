package com.bishe.photo.service;

import java.util.List;

import com.bishe.photo.entity.Photo;

public interface PhotoService {
	
	public Integer save(Photo photo);
	
	public List<Photo> findAll(Integer belongId);
	
	public Photo findById(Integer id);
	
	public void delete(Integer id);
}
