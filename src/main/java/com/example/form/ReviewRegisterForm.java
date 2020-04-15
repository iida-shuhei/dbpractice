package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class ReviewRegisterForm {

	// Review
	private Integer shopId;
	private Integer userId;
	@NotBlank(message = "ラーメン名を入力してください")
	private String ramenName;
	@NotBlank(message = "価格を入力してください")
	private String ramenPrice;
	private Integer ramenImagePathId;

	// RamenImage
	@NotNull(message = "画像を選択してください")
	private MultipartFile ramenImage;

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

	public String getRamenPrice() {
		return ramenPrice;
	}

	public void setRamenPrice(String ramenPrice) {
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

	
}
