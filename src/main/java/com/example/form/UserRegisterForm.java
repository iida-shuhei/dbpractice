package com.example.form;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisterForm {

	private Integer userId;
	@NotBlank(message = "名前を入力してください")
	private String userName;
	private Integer mailTypeId;
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "アドレスが不正です")
	private String mailAddress;
	@NotBlank(message = "パスワードを入力してください")
	private String password;
	@NotBlank(message = "確認用パスワードを入力してください")
	private String confirmationPassword;
	private String createdBy;
	private Timestamp createdAt;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "UserRegisterForm [userId=" + userId + ", userName=" + userName + ", mailTypeId=" + mailTypeId
				+ ", mailAddress=" + mailAddress + ", password=" + password + ", confirmationPassword="
				+ confirmationPassword + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", version="
				+ version + "]";
	}

}
