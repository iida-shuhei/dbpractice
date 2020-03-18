package com.example.domain;

import java.sql.Timestamp;

public class Ramen {

	private Integer ramenId;
	private Integer shopId;
	private String ramenName;
	private Integer ramenPrice;
	private Integer ramenImagePathId;
	private RamenImage ramenImage;
	private String createdBy;
	private Timestamp createdAt;
	private String updatedBy;
	private Timestamp updatedAt;
	private Integer version;
	private String deletedBy;
	private Timestamp deletedAt;

	public Integer getRamenId() {
		return ramenId;
	}

	public void setRamenId(Integer ramenId) {
		this.ramenId = ramenId;
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

	public RamenImage getRamenImage() {
		return ramenImage;
	}

	public void setRamenImage(RamenImage ramenImage) {
		this.ramenImage = ramenImage;
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
		return "Ramen [ramenId=" + ramenId + ", shopId=" + shopId + ", ramenName=" + ramenName + ", ramenPrice="
				+ ramenPrice + ", ramenImagePathId=" + ramenImagePathId + ", ramenImage=" + ramenImage + ", createdBy="
				+ createdBy + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt
				+ ", version=" + version + ", deletedBy=" + deletedBy + ", deletedAt=" + deletedAt + "]";
	}

}
