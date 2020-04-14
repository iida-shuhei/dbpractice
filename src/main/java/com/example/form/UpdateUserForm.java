package com.example.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UpdateUserForm {

	private Integer userId;
	private String userName;
	private String userMail;
	private String password;
	private String confirmationPassword;
	private MultipartFile iconImagePath;
}
