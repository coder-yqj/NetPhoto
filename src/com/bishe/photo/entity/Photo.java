package com.bishe.photo.entity;

import java.io.Serializable;
import java.util.List;

public class Photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9127412389169563955L;

	/**
	 * 照片id
	 */
	private Integer id;

	/**
	 * 照片名
	 */
	private String name;

	/**
	 * 照片url
	 */
	private String photoUrl;

	/**
	 * 属于哪个相册
	 */
	private Integer belongId;

	private Integer userId;

	private List<Comment> comments;

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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


	public Integer getBelongId() {
		return belongId;
	}

	public void setBelongId(Integer belongId) {
		this.belongId = belongId;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Photo other = (Photo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Photo(String name, String photoUrl, Integer belongId, Integer userId) {
		super();
		this.name = name;
		this.photoUrl = photoUrl;
		this.belongId = belongId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", name=" + name + ", photoUrl=" + photoUrl
				+ ", belongId=" + belongId + ", userId=" + userId
				+ ", comments=" + comments + "]";
	}

 
	 

}
