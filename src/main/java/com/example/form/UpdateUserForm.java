package com.example.form;

import org.springframework.web.multipart.MultipartFile;

public class UpdateUserForm {

	private Integer userId;
	private String userName;
	private String userMail;
	private String password;
	private String confirmationPassword;
	private MultipartFile iconImagePath;
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
	public MultipartFile getIconImagePath() {
		return iconImagePath;
	}
	public void setIconImagePath(MultipartFile iconImagePath) {
		this.iconImagePath = iconImagePath;
	}
	
	
}
