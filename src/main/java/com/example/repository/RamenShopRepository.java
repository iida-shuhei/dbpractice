package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.domain.Ramen;
import com.example.domain.RamenShop;
import com.example.domain.RamenShopTime;

/**
 * ラーメン店舗を管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class RamenShopRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	// Insert時に自動採番されたIDを取得する
	private SimpleJdbcInsert insert;

	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("ramen_shops");
		insert = withTableName.usingGeneratedKeyColumns("shop_id");
	}

	private static final ResultSetExtractor<List<RamenShop>> RAMEN_SHOP_RESULT_SET_EXTRACTOR = (rs) -> {
		List<RamenShop> ramenShopList = new ArrayList<>();
		int preId = 0;
		List<Ramen> ramenList = null;

		while (rs.next()) {

			int nowId = rs.getInt("r_shop_id");
			if (nowId != preId) {
				RamenShop ramenShop = new RamenShop();
				ramenShop.setShopId(rs.getInt("r_shop_id"));
				ramenShop.setShopName(rs.getString("shop_name"));
				ramenShop.setZipcode(rs.getString("zipcode"));
				ramenShop.setPrefecture(rs.getString("prefecture"));
				ramenShop.setCity(rs.getString("city"));
				ramenShop.setOther(rs.getString("other"));
				ramenShop.setHolidays(rs.getString("holidays"));
				ramenShop.setCreatedBy(rs.getString("created_by"));
				ramenShop.setCreatedAt(rs.getTimestamp("created_at"));
				ramenShop.setUpdatedBy(rs.getString("updated_by"));
				ramenShop.setUpdatedAt(rs.getTimestamp("updated_at"));
				ramenShop.setVersion(rs.getInt("version"));
				ramenShop.setDeletedBy(rs.getString("deleted_by"));
				ramenShop.setDeletedAt(rs.getTimestamp("deleted_at"));

				RamenShopTime ramenShopTime = new RamenShopTime();
				ramenShopTime.setShopId(rs.getInt("t_shop_id"));
				ramenShopTime.setDaysId(rs.getInt("days_id"));
				ramenShopTime.setNoonStartTime(rs.getString("noon_start_time"));
				ramenShopTime.setNoonEndTime(rs.getString("noon_end_time"));
				ramenShopTime.setNightStartTime(rs.getString("night_start_time"));
				ramenShopTime.setNightEndTime(rs.getString("night_end_time"));
				ramenShopTime.setOtherTime(rs.getString("other_time"));
				ramenShop.setRamenShopTime(ramenShopTime);

				ramenList = new ArrayList<>();
				ramenShop.setRamenList(ramenList);
				ramenShopList.add(ramenShop);
			}

			if (rs.getInt("ramen_id") != 0) {

				Ramen ramen = new Ramen();
				ramen.setRamenId(rs.getInt("ramen_id"));
				ramen.setShopId(rs.getInt("shop_id"));
				ramen.setRamenName(rs.getString("ramen_name"));
				ramen.setRamenPrice(rs.getInt("ramen_price"));
				ramen.setRamenImagePathId(rs.getInt("ramen_image_path_id"));
				ramen.setCreatedBy(rs.getString("created_by"));
				ramen.setCreatedAt(rs.getTimestamp("created_at"));
				ramen.setUpdatedBy(rs.getString("updated_by"));
				ramen.setUpdatedAt(rs.getTimestamp("updated_at"));
				ramen.setVersion(rs.getInt("version"));
				ramen.setDeletedBy(rs.getString("deleted_by"));
				ramen.setDeletedAt(rs.getTimestamp("deleted_at"));
				ramenList.add(ramen);
			}
			preId = nowId;
		}
		return ramenShopList;
	};

	/**
	 * ラーメン店を登録する.
	 * 
	 * @param ramenShop ラーメン店
	 * @return ラーメン情報
	 */
	public RamenShop insert(RamenShop ramenShop) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(ramenShop);
		Number key = insert.executeAndReturnKey(param);
		ramenShop.setShopId(key.intValue());
		return ramenShop;
	}
	
	/**
	 * ラーメン店をすべて検索.
	 * 
	 * @return ラーメン店の情報.
	 */
	public List<RamenShop> findAll() {
		String sql = "select r.shop_id r_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"created_by,\n" + 
				"created_at,\n" + 
				"updated_by,\n" + 
				"updated_at,\n" + 
				"version,\n" + 
				"deleted_by,\n" + 
				"deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days_id, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time\n" + 
				"from ramen_shops as r\n" + 
				"left join ramen_shops_times as t\n" + 
				"on r.shop_id = t.shop_id";
		return template.query(sql, RAMEN_SHOP_RESULT_SET_EXTRACTOR);
	}
}
