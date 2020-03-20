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
import com.example.domain.RamenImage;
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

			int nowId = rs.getInt("s_shop_id");
			if (nowId != preId) {
				RamenShop ramenShop = new RamenShop();
				ramenShop.setShopId(nowId);
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
				ramenShopTime.setShopId(ramenShop.getShopId());
				ramenShopTime.setDays(rs.getString("days"));
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
				ramen.setShopId(rs.getInt("r_shop_id"));
				ramen.setRamenName(rs.getString("ramen_name"));
				ramen.setRamenPrice(rs.getInt("ramen_price"));
				ramen.setRamenImagePathId(rs.getInt("ramen_image_path_id"));
				ramen.setCreatedBy(rs.getString("r_created_by"));
				ramen.setCreatedAt(rs.getTimestamp("r_created_at"));
				ramen.setUpdatedBy(rs.getString("r_updated_by"));
				ramen.setUpdatedAt(rs.getTimestamp("r_updated_at"));
				ramen.setVersion(rs.getInt("r_version"));
				ramen.setDeletedBy(rs.getString("r_deleted_by"));
				ramen.setDeletedAt(rs.getTimestamp("r_deleted_at"));
				
				RamenImage ramenImage = new RamenImage();
				ramenImage.setImageId(rs.getInt("image_id"));
				ramenImage.setImagePath(rs.getString("image_path"));
				ramen.setRamenImage(ramenImage);
				
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
				"s.deleted_at s_deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time,\n" + 
				"ramen_id,\n" + 
				"r.shop_id r_shop_id,\n" + 
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path\n" + 
				"from ramen_shops as s\n" + 
				"left join ramen_shops_times as t\n" + 
				"on s.shop_id = t.shop_id\n" + 
				"left join ramens as r\n" + 
				"on s.shop_id = r.shop_id\n" + 
				"left join ramen_images\n" + 
				"on r.ramen_image_path_id = image_id";
		return template.query(sql, RAMEN_SHOP_RESULT_SET_EXTRACTOR);
	}
}
