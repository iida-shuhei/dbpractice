package com.example.form;

import java.sql.Timestamp;
import java.util.List;

import com.example.domain.RamenShopTime;

import lombok.Data;

@Data
public class RamenShopRegisterForm {

	private String shopName;
	private String zipcode;
	private String prefecture;
	private String city;
	private String other;
	private String holidays;
	private String createdBy;
	private Timestamp createdAt;
	
	private List<RamenShopTime> ramenShopTimeList;

}
