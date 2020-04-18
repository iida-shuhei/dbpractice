package com.example.form;

public class ResetPasswordForm {

	private String userMail;
	private String token;
	private String password;
	private String confirmationPassword;

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	@Override
	public String toString() {
		return "ResetPasswordForm [userMail=" + userMail + ", token=" + token + ", password=" + password
				+ ", confirmationPassword=" + confirmationPassword + "]";
	}

}
