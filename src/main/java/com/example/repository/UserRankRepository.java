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
	
	public List<UserRank> findAll() {
		String sql = "select \n" + 
				"case when rank_id = 1 then '0〜5'\n" + 
				"     when rank_id = 2 then '6〜10'\n" + 
				"     when rank_id = 3 then '11〜15'\n" + 
				"     when rank_id = 4 then '16〜20'\n" + 
				"     when rank_id = 5 then '21〜25'\n" + 
				"     when rank_id = 6 then '26〜30'\n" + 
				"     when rank_id = 7 then '31〜40'\n" + 
				"     when rank_id = 8 then '41〜50'\n" + 
				"     when rank_id = 9 then '51〜60'\n" + 
				"     when rank_id = 10 then '61〜70'\n" + 
				"     when rank_id = 11 then '71〜80'\n" + 
				"     when rank_id = 12 then '81〜90'\n" + 
				"     when rank_id = 13 then '91〜110'\n" + 
				"     when rank_id = 14 then '111〜130'\n" + 
				"     when rank_id = 15 then '131〜150'\n" + 
				"     when rank_id = 16 then '151〜180'\n" + 
				"     when rank_id = 17 then '181〜210'\n" + 
				"     when rank_id = 18 then '211〜240'\n" + 
				"     when rank_id = 19 then '241〜'\n" + 
				"end as totalRamens,\n" + 
				"case when rank_id = 1 then 'ルーキー1'\n" + 
				"when rank_id = 2 then 'ルーキー2'\n" + 
				"when rank_id = 3 then 'ルーキー3'\n" + 
				"when rank_id = 4 then 'ブロンズ1'\n" + 
				"when rank_id = 5 then 'ブロンズ2'\n" + 
				"when rank_id = 6 then 'ブロンズ3'\n" + 
				"when rank_id = 7 then 'シルバー1'\n" + 
				"when rank_id = 8 then 'シルバー2'\n" + 
				"when rank_id = 9 then 'シルバー3'\n" + 
				"when rank_id = 10 then 'ゴールド1'\n" + 
				"when rank_id = 11 then 'ゴールド2'\n" + 
				"when rank_id = 12 then 'ゴールド3'\n" + 
				"when rank_id = 13 then 'プラチナ1'\n" + 
				"when rank_id = 14 then 'プラチナ2'\n" + 
				"when rank_id = 15 then 'プラチナ3'\n" + 
				"when rank_id = 16 then 'レジェンド1'\n" + 
				"when rank_id = 17 then 'レジェンド2'\n" + 
				"when rank_id = 18 then 'レジェンド3'\n" + 
				"when rank_id = 19 then 'キング'\n" + 
				"end as rank\n" + 
				"from user_ranks;";
		return template.query(sql, rowMapper);
	}
}