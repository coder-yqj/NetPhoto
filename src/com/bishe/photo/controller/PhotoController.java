package com.bishe.photo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bishe.photo.domain.Message;
import com.bishe.photo.entity.Photo;
import com.bishe.photo.entity.User;
import com.bishe.photo.service.PhotoService;

@RequestMapping("/photo")
@Controller
public class PhotoController {
	static Logger logger = Logger.getLogger(PhotoController.class);
	@Autowired
	private PhotoService photoService;
	
	
	@ResponseBody
	 @RequestMapping(value="/upload",method=RequestMethod.POST)
	    private Message fildUpload(@RequestParam(value="file",required=false) MultipartFile file[],
	    		String name,Integer belongId,HttpServletRequest request)throws Exception{
	        //基本表单
	         
	        //获得物理路径webapp所在路径
	        String pathRoot = request.getSession().getServletContext().getRealPath("");
	        String path="";
	        List<String> listImagePath=new ArrayList<String>();
	        for (MultipartFile mf : file) {
            if(!mf.isEmpty()){
                //生成uuid作为文件名称
//                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                //获得文件类型（可以判断如果不是图片，禁止上传）
//                String contentType=file.getContentType();
//                System.out.println(contentType);
                //获得文件后缀名称
//                String imageName=contentType.substring(contentType.indexOf("/")+1);
                String newFileName = UUID.randomUUID().toString().replaceAll("-","") + "."
        				+ FilenameUtils.getExtension(name);
                System.out.println("imageName:"+newFileName);
                path="/upload/"+newFileName;
                mf.transferTo(new File(pathRoot+path));
                listImagePath.add(path);
                System.out.println(path);
                logger.info("name:"+name);
                logger.info("belongId:"+belongId);
                User user = (User) request.getSession().getAttribute("user");
                Integer saveId = null;
                try {
                	saveId = photoService.save(new Photo(name, path, belongId, user.getId()));
                } catch (Exception e) {
                	logger.error("上传照片出错");
                	e.printStackTrace();
                	return new Message("0","保存相片失败");
                }
            }
	        }
	        return this.findAll(belongId);
	    }
	 
	@RequestMapping("/findByid")
	@ResponseBody
	public Message findById(Integer id){
		logger.info("查询id为："+id+" 的照片");
		Photo photo = photoService.findById(id);
		List<Photo> photos = new ArrayList<>();
		photos.add(photo);
		return new Message("1",photos);
	}
	
	
	
	 @ResponseBody
	 @RequestMapping("/findAll")
	 public Message findAll(Integer belongId){
		 logger.info("查询该相"+belongId+"的所有照片");
		 List<Photo> photos;
		try {
			photos = photoService.findAll(belongId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("返回相应相册的所有照片出错");
			return new Message("0","返回相应相册的所有照片出错");
		}
		 return new Message("1",photos);
	 }
	
	 
	 
	 @ResponseBody
		@RequestMapping("/delete")
		public Message delete(Integer id,Integer belongId){
			logger.info("删除照片");
			logger.info("删除照片id为"+id);
			try {
				photoService.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
				return new Message("0","删除失败");
			}
			
			return this.findAll(belongId);
		}
}
