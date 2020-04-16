package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.UserRank;

/**
 * ユーザーのランクを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class UserRankRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	//rowMapper破壊神
	private static final RowMapper<UserRank> rowMapper = new BeanPropertyRowMapper<UserRank>(UserRank.class);
	
	/**
	 * ランクIDからランク名を検索する.
	 * 
	 * @param rank_id ランクID
	 * @return ランク名
	 */
	public UserRank load(Integer rank_id) {
		String sql = "select rank from user_ranks where rank_id =:rankId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("rankId", rank_id);
		return template.queryForObject(sql, param, rowMapper);
	}
	
	/**
	 * ユーザーランクを全件取得する.
	 * 
	 * @return ユーザーランク情報
	 */
	public List<UserRank> findAll() {
		String sql = "select rank_id, user_rank from user_ranks;";
		return template.query(sql, rowMapper);
	}
}