package com.example.domain;

public class RamenShopTime {
	
	private Integer ramenShopTimeId;
	private Integer shopId;
	private String days;
	private String noonStartTime;
	private String noonEndTime;
	private String nightStartTime;
	private String nightEndTime;
	private String otherTime;
	public Integer getRamenShopTimeId() {
		return ramenShopTimeId;
	}
	public void setRamenShopTimeId(Integer ramenShopTimeId) {
		this.ramenShopTimeId = ramenShopTimeId;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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
	
	

}
