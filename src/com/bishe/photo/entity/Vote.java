package com.bishe.photo.entity;

public class Vote {
	private Integer id;
	private Integer photoId;
	private Double voteValue;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	 
	 
	public Double getVoteValue() {
		return voteValue;
	}
	public void setVoteValue(Double voteValue) {
		this.voteValue = voteValue;
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
		Vote other = (Vote) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vote [id=" + id + ", photoId=" + photoId + ", voteValue="
				+ voteValue + "]";
	}
	
	
	
}
