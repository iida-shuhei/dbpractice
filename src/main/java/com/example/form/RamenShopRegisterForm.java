package com.example.form;

import java.sql.Timestamp;
import java.util.List;

import com.example.domain.RamenShopTime;

public class RamenShopRegisterForm {

	private String shopName;
	private String zipcode;
	private String prefecture;
	private String city;
	private String other;
	private String holidays;
	private String createdBy;
	private Timestamp createdAt;
	
	private List<RamenShopTime> ramenShopTimeList;

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

	public List<RamenShopTime> getRamenShopTimeList() {
		return ramenShopTimeList;
	}

	public void setRamenShopTimeList(List<RamenShopTime> ramenShopTimeList) {
		this.ramenShopTimeList = ramenShopTimeList;
	}

	
}
