package com.example.domain;


import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class Article {

	private Integer articleId;
	private Integer userId;
	private Integer shopId;
	private List<RamenShop> ramenShopList;
	private String comments;
	
	private String createdBy;
	private Timestamp createdAt;
	private String updatedBy;
	private Timestamp updatedAt;
	private Integer version;
	private String deletedBy;
	private Timestamp deletedAt;
}
