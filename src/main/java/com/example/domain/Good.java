package com.example.domain;

public class Good {
	
	private Integer id;
	private Integer userId;
	private Integer reviewId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	@Override
	public String toString() {
		return "Good [id=" + id + ", userId=" + userId + ", reviewId=" + reviewId + "]";
	}
	
	
	

}
