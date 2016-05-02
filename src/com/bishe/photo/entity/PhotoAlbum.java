package com.bishe.photo.entity;

import java.io.Serializable;

public class PhotoAlbum implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5541984823630830621L;

	/**
	 * 相册id
	 */
	private Integer id;

	/**
	 * 相册名
	 */
	private String name;

	/**
	 * 相册类型 0 --> 隐私 1 --> 公开
	 */
	private Integer type;

	/**
	 * 相册封面url
	 */
	private String coverUrl;
	
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
		PhotoAlbum other = (PhotoAlbum) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public PhotoAlbum() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PhotoAlbum(String name, Integer type) {
		super();
		this.name = name;
		this.type = type;
	}
	

	public PhotoAlbum(String name, Integer type, Integer userId) {
		super();
		this.name = name;
		this.type = type;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PhotoAlbum [id=" + id + ", name=" + name + ", type=" + type
				+ ", coverUrl=" + coverUrl + ", userId=" + userId + "]";
	}

	 

 
}
