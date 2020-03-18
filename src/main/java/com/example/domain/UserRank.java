package com.example.domain;

public class UserRank {

	private Integer rankId;
	private String rank;

	public Integer getRankId() {
		return rankId;
	}

	public void setRankId(Integer rankId) {
		this.rankId = rankId;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "UserRank [rankId=" + rankId + ", rank=" + rank + "]";
	}

}
