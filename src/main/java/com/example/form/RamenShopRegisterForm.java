package com.example.form;

import java.sql.Timestamp;

public class RamenShopRegisterForm {

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
	private String days;
	private String noonStartTime;
	private String noonEndTime;
	private String nightStartTime;
	private String nightEndTime;
	private String otherTime;

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

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
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

	@Override
	public String toString() {
		return "RamenShopRegisterForm [shopName=" + shopName + ", zipcode=" + zipcode + ", prefecture=" + prefecture
				+ ", city=" + city + ", other=" + other + ", holidays=" + holidays + ", createdBy=" + createdBy
				+ ", createdAt=" + createdAt + ", days=" + days + ", noonStartTime=" + noonStartTime + ", noonEndTime="
				+ noonEndTime + ", nightStartTime=" + nightStartTime + ", nightEndTime=" + nightEndTime + ", otherTime="
				+ otherTime + "]";
	}

}
