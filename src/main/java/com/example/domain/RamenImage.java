package com.example.domain;

public class RamenImage {

	private Integer imageId;
	private String imagePath;

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "RamenImage [imageId=" + imageId + ", imagePath=" + imagePath + "]";
	}

}
