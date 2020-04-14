package com.example.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
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


}