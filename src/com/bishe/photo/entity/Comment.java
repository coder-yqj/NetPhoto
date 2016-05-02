package com.bishe.photo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4783571236470242338L;
	private Integer id;
	private String content; // 评论内容
	private Integer photoId;// 评论相册的Id
	private Integer userId;// 评论人Id
	private String userName; // 评论人
	private Timestamp date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Comment(Integer id, String content, Integer photoId, Integer userId,
			String userName, Timestamp date) {
		super();
		this.id = id;
		this.content = content;
		this.photoId = photoId;
		this.userId = userId;
		this.userName = userName;
		this.date = date;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", photoId="
				+ photoId + ", userId=" + userId + ", userName=" + userName
				+ ", date=" + date + "]";
	}

}
