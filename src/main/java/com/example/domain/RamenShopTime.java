package com.example.domain;

import lombok.Data;

@Data
public class RamenShopTime {
	
	private Integer ramenShopTimeId;
	private Integer shopId;
	private String days;
	private String noonStartTime;
	private String noonEndTime;
	private String nightStartTime;
	private String nightEndTime;
	private String otherTime;

}
