package com.example.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

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
	
	private static final RowMapper<RamenShop> RAMEN_SHOP_ROW_MAPPER = (rs,i) -> {
		RamenShop ramenShop = new RamenShop();
		ramenShop.setShopId(rs.getInt("s_shop_id"));
		ramenShop.setShopName(rs.getString("shop_name"));
		ramenShop.setZipcode(rs.getString("zipcode"));
		ramenShop.setPrefecture(rs.getString("prefecture"));
		ramenShop.setCity(rs.getString("city"));
		ramenShop.setOther(rs.getString("other"));
		ramenShop.setHolidays(rs.getString("holidays"));
		ramenShop.setCreatedBy(rs.getString("s_created_by"));
		ramenShop.setCreatedAt(rs.getTimestamp("s_created_at"));
		ramenShop.setUpdatedBy(rs.getString("s_updated_by"));
		ramenShop.setUpdatedAt(rs.getTimestamp("s_updated_at"));
		ramenShop.setVersion(rs.getInt("s_version"));
		ramenShop.setDeletedBy(rs.getString("s_deleted_by"));
		ramenShop.setDeletedAt(rs.getTimestamp("s_deleted_at"));

		RamenShopTime ramenShopTime = new RamenShopTime();
		ramenShopTime.setShopId(rs.getInt("t_shop_id"));
		ramenShopTime.setDays(rs.getString("days"));
		ramenShopTime.setNoonStartTime(rs.getString("noon_start_time"));
		ramenShopTime.setNoonEndTime(rs.getString("noon_end_time"));
		ramenShopTime.setNightStartTime(rs.getString("night_start_time"));
		ramenShopTime.setNightEndTime(rs.getString("night_end_time"));
		ramenShopTime.setOtherTime(rs.getString("other_time"));
		ramenShop.setRamenShopTime(ramenShopTime);
		
		return ramenShop;

	};
	
	private static final RowMapper<RamenShop> SHOP_ROW_MAPPER = (rs,i) -> {
		RamenShop ramenShop = new RamenShop();
		ramenShop.setShopId(rs.getInt("s_shop_id"));
		ramenShop.setShopName(rs.getString("shop_name"));
		ramenShop.setZipcode(rs.getString("zipcode"));
		ramenShop.setPrefecture(rs.getString("prefecture"));
		ramenShop.setCity(rs.getString("city"));
		ramenShop.setOther(rs.getString("other"));
		ramenShop.setHolidays(rs.getString("holidays"));
		ramenShop.setCreatedBy(rs.getString("s_created_by"));
		ramenShop.setCreatedAt(rs.getTimestamp("s_created_at"));
		ramenShop.setUpdatedBy(rs.getString("s_updated_by"));
		ramenShop.setUpdatedAt(rs.getTimestamp("s_updated_at"));
		ramenShop.setVersion(rs.getInt("s_version"));
		ramenShop.setDeletedBy(rs.getString("s_deleted_by"));
		ramenShop.setDeletedAt(rs.getTimestamp("s_deleted_at"));

		return ramenShop;

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
//	public List<RamenShop> findAll() {
//		String sql = "select s.shop_id s_shop_id, \n" + 
//				"shop_name, \n" + 
//				"zipcode,\n" + 
//				"prefecture,\n" + 
//				"city,\n" + 
//				"other,\n" + 
//				"holidays,\n" + 
//				"s.created_by s_created_by,\n" + 
//				"s.created_at s_created_at,\n" + 
//				"s.updated_by s_updated_by,\n" + 
//				"s.updated_at s_updated_at,\n" + 
//				"s.version s_version,\n" + 
//				"s.deleted_by s_deleted_by,\n" + 
//				"s.deleted_at s_deleted_at,\n" + 
//				"t.shop_id t_shop_id, \n" + 
//				"days, \n" + 
//				"noon_start_time,\n" + 
//				"noon_end_time,\n" + 
//				"night_start_time,\n" + 
//				"night_end_time,\n" + 
//				"other_time " + 
//				"from ramen_shops as s\n" + 
//				"left join ramen_shops_times as t\n" + 
//				"on s.shop_id = t.shop_id";
//		return template.query(sql, RAMEN_SHOP_ROW_MAPPER);
//	}
	
	/**
	 * ラーメン店をすべて検索.
	 * 
	 * @return ラーメン店の情報.
	 */
	public List<RamenShop> findAll() {
		String sql = "select s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at\n" + 
				"from ramen_shops as s";
		return template.query(sql, SHOP_ROW_MAPPER);
	}
	
	/**
	 * 店舗名からラーメン店舗を検索する.
	 * 
	 * @param shopName 店舗名
	 * @return ラーメン店舗
	 */
	public List<RamenShop> findByShopName(String shopName) {
		String sql = "select s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at\n" + 
				"from ramen_shops as s\n" +
				"where shop_name Ilike :shopName order by shop_name";
		SqlParameterSource param = new MapSqlParameterSource().addValue("shopName", '%' + shopName + '%');
		return template.query(sql, param, SHOP_ROW_MAPPER);
	}
	
	/**
	 * ショップIDからラーメン店舗情報を検索する.
	 * 
	 * @param shopId ショップID
	 * @return ラーメン店舗情報
	 */
	public RamenShop load(Integer shopId) {
		String sql = "select s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at\n" + 
				"from ramen_shops as s\n" +
				"where shop_id =:shopId"; 
		SqlParameterSource param = new MapSqlParameterSource().addValue("shopId", shopId);
		return template.queryForObject(sql, param, SHOP_ROW_MAPPER);
	}
}