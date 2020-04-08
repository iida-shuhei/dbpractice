package com.example.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Review {

	private Integer reviewId;
	private Integer shopId;
	private Integer userId;
	private String ramenName;
	private Integer ramenPrice;
	private Integer ramenImagePathId;
	private RamenShop ramenShop;
	private RamenImage ramenImage;
	private User user;
	
	private String createdBy;
	private Timestamp createdAt;
	private String updatedBy;
	private Timestamp updatedAt;
	private Integer version;
	private String deletedBy;
	private Timestamp deletedAt;

}
