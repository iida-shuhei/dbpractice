package com.example.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RamenShop {

	private Integer shopId;
	private String shopName;
	private String zipcode;
	private String prefecture;
	private String city;
	private String other;
	private String holidays;
	private RamenShopTime ramenShopTime;
	
	private String createdBy;
	private Timestamp createdAt;
	private String updatedBy;
	private Timestamp updatedAt;
	private Integer version;
	private String deletedBy;
	private Timestamp deletedAt;

}