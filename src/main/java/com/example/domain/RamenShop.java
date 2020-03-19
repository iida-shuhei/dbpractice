package com.example.domain;

import java.sql.Timestamp;
import java.util.List;

public class RamenShop {

	private Integer shopId;
	private String shopName;
	private String zipcode;
	private String prefecture;
	private String city;
	private String other;
	private String holidays;
	private RamenShopTime ramenShopTime;
	private List<Ramen> ramenList;
	private String createdBy;
	private Timestamp createdAt;
	private String updatedBy;
	private Timestamp updatedAt;
	private Integer version;
	private String deletedBy;
	private Timestamp deletedAt;

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

	public RamenShopTime getRamenShopTime() {
		return ramenShopTime;
	}

	public void setRamenShopTime(RamenShopTime ramenShopTime) {
		this.ramenShopTime = ramenShopTime;
	}

	public List<Ramen> getRamenList() {
		return ramenList;
	}

	public void setRamenList(List<Ramen> ramenList) {
		this.ramenList = ramenList;
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

	@Override
	public String toString() {
		return "RamenShop [shopId=" + shopId + ", shopName=" + shopName + ", zipcode=" + zipcode + ", prefecture="
				+ prefecture + ", city=" + city + ", other=" + other + ", holidays=" + holidays + ", ramenShopTime="
				+ ramenShopTime + ", ramenList=" + ramenList + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt + ", version=" + version + ", deletedBy="
				+ deletedBy + ", deletedAt=" + deletedAt + "]";
	}

}
