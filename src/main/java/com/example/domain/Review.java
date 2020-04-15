package com.example.domain;

import java.sql.Timestamp;

public class Review {

	private Integer reviewId;
	private Integer shopId;
	private Integer userId;
	private String ramenName;
	private Integer ramenPrice;
	private Integer ramenImagePathId;
	private RamenShop ramenShop;
	private RamenImage ramenImage;
	private User user;
	
	private String createdBy;
	private Timestamp createdAt;
	private String updatedBy;
	private Timestamp updatedAt;
	private Integer version;
	private String deletedBy;
	private Timestamp deletedAt;
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRamenName() {
		return ramenName;
	}
	public void setRamenName(String ramenName) {
		this.ramenName = ramenName;
	}
	public Integer getRamenPrice() {
		return ramenPrice;
	}
	public void setRamenPrice(Integer ramenPrice) {
		this.ramenPrice = ramenPrice;
	}
	public Integer getRamenImagePathId() {
		return ramenImagePathId;
	}
	public void setRamenImagePathId(Integer ramenImagePathId) {
		this.ramenImagePathId = ramenImagePathId;
	}
	public RamenShop getRamenShop() {
		return ramenShop;
	}
	public void setRamenShop(RamenShop ramenShop) {
		this.ramenShop = ramenShop;
	}
	public RamenImage getRamenImage() {
		return ramenImage;
	}
	public void setRamenImage(RamenImage ramenImage) {
		this.ramenImage = ramenImage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	public Timestamp getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	
}
