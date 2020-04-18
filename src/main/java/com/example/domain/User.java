package com.example.domain;

import java.sql.Timestamp;

public class User {

	private Integer userId;
	private String userName;
	private String userMail;
	private String password;
	private Integer userIconId;
	private Integer userRankId;
	private UserIcon userIcon;
	private UserRank userRank;
	private String createdBy;
	private Timestamp createdAt;
	private String updatedBy;
	private Timestamp updatedAt;
	private String deletedBy;
	private Timestamp deletedAt;
	private Integer version;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserIconId() {
		return userIconId;
	}
	public void setUserIconId(Integer userIconId) {
		this.userIconId = userIconId;
	}
	public Integer getUserRankId() {
		return userRankId;
	}
	public void setUserRankId(Integer userRankId) {
		this.userRankId = userRankId;
	}
	public UserIcon getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(UserIcon userIcon) {
		this.userIcon = userIcon;
	}
	public UserRank getUserRank() {
		return userRank;
	}
	public void setUserRank(UserRank userRank) {
		this.userRank = userRank;
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	
}