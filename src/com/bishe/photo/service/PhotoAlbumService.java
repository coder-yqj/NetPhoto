package com.bishe.photo.service;

import java.util.List;

import com.bishe.photo.entity.PhotoAlbum;

public interface PhotoAlbumService {

	/**
	 * 保存相册
	 * @param photoAlbum
	 */
	public Integer saveAlbum(PhotoAlbum photoAlbum);
	
	
	public PhotoAlbum findById(Integer id);
	
	
	/**
	 * 返回所有相册
	 * @param userId
	 * @return
	 */
	public List<PhotoAlbum> findAll(Integer userId);
	
	/**
	 * 根据相册id删除相册
	 * @param id
	 */
	public void delete(Integer id);
	
	
	/**
	 * 更新相册信息
	 * @param photoAlbum  更新后的相册信息
	 */
	public void update(PhotoAlbum photoAlbum);
	
	
	public void updateCover(String url ,Integer id);
	
	
}
