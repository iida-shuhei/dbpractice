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
		String sql = "insert into ramen_shop_times(shop_id,days_id,noon_start_time,noon_end_time,night_start_time,night_end_time,other_time)"
				+ "values(:shopId,:daysId,:noonStartTime,:noonEndTime,:nightStartTime,:nightEndTime,:otherTime)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(ramenShopTime);
		template.update(sql, param);
	}
}
