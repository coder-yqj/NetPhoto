package com.bishe.photo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishe.photo.domain.Message;
import com.bishe.photo.entity.Photo;
import com.bishe.photo.entity.PhotoAlbum;
import com.bishe.photo.entity.User;
import com.bishe.photo.service.PhotoAlbumService;

@Controller
@RequestMapping("/album")
public class PhotoAlbumController {
	static Logger logger = Logger.getLogger(PhotoAlbumController.class);
	@Autowired
	private PhotoAlbumService photoAlbumService;
	
	//添加相册
	@ResponseBody
	@RequestMapping("/add")
	public Message addAlbum(String name,Integer type,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		logger.info("sessionId:"+session.getId());
		logger.info("user:"+user);
		PhotoAlbum photoAlbum = new PhotoAlbum(name,type,user.getId());
		Integer saveId = photoAlbumService.saveAlbum(photoAlbum);
		return this.findById(saveId);
	}
	
	
	@RequestMapping("/findById")
	@ResponseBody
	public Message findById(Integer id){
		logger.info("查询id为："+id+" 的照片");
		PhotoAlbum photos = photoAlbumService.findById(id);
		List<PhotoAlbum> photoAlbum = new ArrayList<>();
		photoAlbum.add(photos);
		return new Message("1",photoAlbum);
	}
	
	@ResponseBody
	@RequestMapping("/findAll")
	public Message findAll(HttpServletRequest request){
		List<PhotoAlbum> photoAlbums;
		try {
			photoAlbums = photoAlbumService.findAll(((User)request.getSession().getAttribute("user")).getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new Message("0","返回所有相册出错");
		}
		logger.info("返回所有photoAlbums:"+photoAlbums);
		return new Message("1",photoAlbums);
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Message delete(Integer id,HttpServletRequest request){
		logger.info("删除相册");
		logger.info("删除相册id为"+id+"的相册");
		try {
			photoAlbumService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Message("0","删除失败");
		}
		
		return this.findAll(request);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Message update(PhotoAlbum photoAlbum){
		
		try {
			photoAlbumService.update(photoAlbum);
		} catch (Exception e) {
			e.printStackTrace();
			return new Message("0","更新失败");
		}
		return new Message("1","更新成功");
	}
	
	
	//设置封面
	@ResponseBody
	@RequestMapping("/setCover")
	public Message setCover(String url,Integer id){
		logger.info("更新相册id为:"+id + " --的封面为:"+url);
		try {
			photoAlbumService.updateCover(url, id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Message("0","设置封面失败");
		}
		return new Message("1","设置封面成功");
	}
	
}
