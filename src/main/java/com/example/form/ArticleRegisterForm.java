package com.example.form;


import org.springframework.web.multipart.MultipartFile;

public class ArticleRegisterForm {

	// Article
	private Integer userId;
	private Integer shopId;

	// Ramen
	private String ramenName;
	private Integer ramenPrice;
	private Integer ramenImagePathId;

	// RamenImage
	private MultipartFile ramenImage;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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

	public MultipartFile getRamenImage() {
		return ramenImage;
	}

	public void setRamenImage(MultipartFile ramenImage) {
		this.ramenImage = ramenImage;
	}

	@Override
	public String toString() {
		return "ArticleRegisterForm [userId=" + userId + ", shopId=" + shopId + ", ramenName=" + ramenName
				+ ", ramenPrice=" + ramenPrice + ", ramenImagePathId=" + ramenImagePathId + ", ramenImage=" + ramenImage
				+ "]";
	}

}
