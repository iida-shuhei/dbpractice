package com.example.form;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisterForm {

	private Integer userId;
	@NotBlank(message = "名前を入力してください")
	private String userName;
	@NotBlank(message = "メールアドレスを入力してください")
	@Email(message = "アドレスが不正です")
	private String userMail;
	@NotBlank(message = "パスワードを入力してください")
	private String password;
	@NotBlank(message = "確認用パスワードを入力してください")
	private String confirmationPassword;
	private String createdBy;
	private Timestamp createdAt;
	private String uuid;

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "UserRegisterForm [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail
				+ ", password=" + password + ", confirmationPassword=" + confirmationPassword + ", createdBy="
				+ createdBy + ", createdAt=" + createdAt + ", uuid=" + uuid + "]";
	}

}
