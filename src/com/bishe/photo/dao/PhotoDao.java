package com.bishe.photo.dao;

import java.util.List;

import com.bishe.photo.annotation.MyAnnotation;
import com.bishe.photo.entity.Photo;

@MyAnnotation
public interface PhotoDao {
	/**
	 * 增加相片
	 * @param photo 相片对象
	 */
	public Integer save(Photo photo);
	
	/**
	 * 返回相应相册的所有照片
	 * @param belongId
	 * @return
	 */
	public List<Photo> findAll(Integer belongId);
	
	public Photo findById(Integer id);
	
	public void delete(Integer id);

}
