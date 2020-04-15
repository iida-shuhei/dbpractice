package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.RamenShopTime;

/**
 * ラーメン店舗の時間を管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class RamenShopTimeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * ラーメン店舗の時間を登録する.
	 * 
	 * @param ramenShopTime ラーメン店舗の時間
	 */
	public void insert(RamenShopTime ramenShopTime) {
		String sql = "insert into ramen_shops_times(shop_id,days,noon_start_time,noon_end_time,night_start_time,night_end_time,other_time)"
				+ "values(:shopId,:days,:noonStartTime,:noonEndTime,:nightStartTime,:nightEndTime,:otherTime)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(ramenShopTime);
		template.update(sql, param);
	}
	
	/**
	 * NULLのものを削除する.
	 * 
	 * @param ramenShopTime ラーメン店舗時間
	 */
	public void delete(RamenShopTime ramenShopTime) {
		String sql = "delete from ramen_shops_times "
				+ "where days is null "
				+ "and noon_start_time is null "
				+ "and noon_end_time is null "
				+ "and night_start_time is null "
				+ "and night_end_time is null "
				+ "and other_time is null";
		SqlParameterSource param = new BeanPropertySqlParameterSource(ramenShopTime);
		template.update(sql, param);
	}
}
