package com.example.domain;

public class UserIcon {

	private Integer iconId;
	private String iconImagePath;

	public Integer getIconId() {
		return iconId;
	}

	public void setIconId(Integer iconId) {
		this.iconId = iconId;
	}

	public String getIconImagePath() {
		return iconImagePath;
	}

	public void setIconImagePath(String iconImagePath) {
		this.iconImagePath = iconImagePath;
	}

	@Override
	public String toString() {
		return "UserIcon [iconId=" + iconId + ", iconImagePath=" + iconImagePath + "]";
	}

}
