package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Favorite;

/**
 * お気に入りを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class FavoriteRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Favorite> FavoriteRowMapper = new BeanPropertyRowMapper<Favorite>(Favorite.class);
	
	/**
	 * お気に入りを登録する.
	 * 
	 * @param userId ユーザーID
	 * @param reviewId レビューID
	 */
	public void register(Integer userId, Integer reviewId) {
		String sql = "insert into favorites(user_id, review_id)values(:userId, :reviewId)";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("reviewId", reviewId);
		template.update(sql, param);
	}
	
	/**
	 * お気に入りを削除する.
	 * 
	 * @param userId ユーザーID
	 * @param reviewId レビューID
	 */
	public void delete(Integer userId, Integer reviewId) {
		String sql = "delete from favorites where user_id =:userId and review_id =:reviewId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId).addValue("reviewId", reviewId);
		template.update(sql, param);
	}
	
	/**
	 * 自分のお気に入りレビューがあるかどうか検索する.
	 * 
	 * @param userId ユーザーID
	 * @param reviewId レビューID
	 * @return
	 */
	public List<Favorite> findByUserIdAndReviewId(Integer userId,Integer reviewId) {
		String sql = "SELECT id,user_id,review_id FROM favorites WHERE user_id = :userId AND review_id = :reviewId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("reviewId", reviewId);
		return template.query(sql, param,FavoriteRowMapper);
	}
}