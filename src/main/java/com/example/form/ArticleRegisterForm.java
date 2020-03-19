package com.example.form;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class ArticleRegisterForm {

	// Article
	private Integer userId;
	private Integer shopId;

	// RamenShop
	private String shopName;
	private String zipcode;
	private String prefecture;
	private String city;
	private String other;
	private String holidays;
	private String createdBy;
	private Timestamp createdAt;

	// RamenShopTime
	private Integer daysId;
	private String noonStartTime;
	private String noonEndTime;
	private String nightStartTime;
	private String nightEndTime;
	private String otherTime;

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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getHolidays() {
		return holidays;
	}

	public void setHolidays(String holidays) {
		this.holidays = holidays;
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

	public Integer getDaysId() {
		return daysId;
	}

	public void setDaysId(Integer daysId) {
		this.daysId = daysId;
	}

	public String getNoonStartTime() {
		return noonStartTime;
	}

	public void setNoonStartTime(String noonStartTime) {
		this.noonStartTime = noonStartTime;
	}

	public String getNoonEndTime() {
		return noonEndTime;
	}

	public void setNoonEndTime(String noonEndTime) {
		this.noonEndTime = noonEndTime;
	}

	public String getNightStartTime() {
		return nightStartTime;
	}

	public void setNightStartTime(String nightStartTime) {
		this.nightStartTime = nightStartTime;
	}

	public String getNightEndTime() {
		return nightEndTime;
	}

	public void setNightEndTime(String nightEndTime) {
		this.nightEndTime = nightEndTime;
	}

	public String getOtherTime() {
		return otherTime;
	}

	public void setOtherTime(String otherTime) {
		this.otherTime = otherTime;
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
		return "ArticleRegisterForm [userId=" + userId + ", shopId=" + shopId + ", shopName=" + shopName + ", zipcode="
				+ zipcode + ", prefecture=" + prefecture + ", city=" + city + ", other=" + other + ", holidays="
				+ holidays + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", daysId=" + daysId
				+ ", noonStartTime=" + noonStartTime + ", noonEndTime=" + noonEndTime + ", nightStartTime="
				+ nightStartTime + ", nightEndTime=" + nightEndTime + ", otherTime=" + otherTime + ", ramenName="
				+ ramenName + ", ramenPrice=" + ramenPrice + ", ramenImagePathId=" + ramenImagePathId + ", ramenImage="
				+ ramenImage + "]";
	}

}
