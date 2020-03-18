package com.example.domain;

public class UserMail {

	private Integer userId;
	private Integer mailTypeId;
	private String mailAddress;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMailTypeId() {
		return mailTypeId;
	}

	public void setMailTypeId(Integer mailTypeId) {
		this.mailTypeId = mailTypeId;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	@Override
	public String toString() {
		return "UserMail [userId=" + userId + ", mailTypeId=" + mailTypeId + ", mailAddress=" + mailAddress + "]";
	}

}
