package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Good;

@Repository
public class GoodRepository {

	
	 @Autowired
	 private NamedParameterJdbcTemplate template;
	 
	 /**
	 * グッドオブジェクトを生成するローマッパー
	 */
	private static final RowMapper<Good> GOOD_ROW_MAPPER = (rs,i) ->{
		 
		 Good good = new Good();
		 good.setId(rs.getInt("id"));
		 good.setUserId(rs.getInt("user_id"));
		 good.setReviewId(rs.getInt("review_id"));
		 return good;
		 
	 };


	/**
	 * いいねを追加する.
	 * @param userId
	 * @param reviewId
	 */
	public void insert(Integer userId,Integer reviewId) {
		String sql = "INSERT INTO goods (user_id,review_id) VALUES(:userId,:reviewId)";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("reviewId", reviewId);
		template.update(sql,param);
	}
	
	
	/**
	 * いいねを削除する.
	 * @param userId
	 * @param reviewId
	 */
	public void delete(Integer userId,Integer reviewId) {
		String sql = "DELETE FROM goods WHERE user_id = :userId AND review_id = :reviewId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("reviewId",reviewId);
		template.update(sql, param);
	}
	
	
	/**
	 * ユーザーIDと記事IDからいいねを探してくる.
	 * 
	 * @param userId 
	 * @param reviewId
	 * @return グッドリスト
	 */
	public List<Good> findByUserIdAndReviewId(Integer userId,Integer reviewId)	{
		String sql = "SELECT id ,user_id,review_id FROM goods WHERE user_id = :userId AND review_id = :reviewId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("reviewId", reviewId);
		return template.query(sql,param,GOOD_ROW_MAPPER);
	}
	
	/**
	 * いいね数を求める.
	 * @param reviewId
	 * @return
	 */
	public Integer good(Integer reviewId) {
		String sql = "select count(*) from goods where review_id = :reviewId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.queryForObject(sql, param, Integer.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}