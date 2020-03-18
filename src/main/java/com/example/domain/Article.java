package com.example.domain;

public class Article {

	private Integer articleId;
	private Integer userId;
	private Integer shopId;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", userId=" + userId + ", shopId=" + shopId + "]";
	}

}
