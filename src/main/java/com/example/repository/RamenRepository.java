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

import com.example.domain.Ramen;
import com.example.domain.RamenImage;

/**
 * ラーメンを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class RamenRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	// Insert時に自動採番されたIDを取得する
	private SimpleJdbcInsert insert;

	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("ramens");
		insert = withTableName.usingGeneratedKeyColumns("ramen_id");
	}
	
	private static final RowMapper<Ramen> RAMEN_ROW_MAPPER = (rs,i) -> {
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
		
		RamenImage ramenImage = new RamenImage();
		ramenImage.setImageId(rs.getInt("image_id"));
		ramenImage.setImagePath(rs.getString("image_path"));
		ramen.setRamenImage(ramenImage);
		
		return ramen;
	};
	
	/**
	 * ラーメンを登録する.
	 * 
	 * @param ramen ラーメン
	 * @return ラーメン情報
	 */
	public Ramen insert(Ramen ramen) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(ramen);
		Number key = insert.executeAndReturnKey(param);
		ramen.setRamenImagePathId(key.intValue());
		return ramen;
	}
	
	public List<Ramen> findByShopId(int shopId) {
		String sql = "select ramen_id,\n" + 
				"shop_id,\n" + 
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"created_by,\n" + 
				"created_at,\n" + 
				"updated_by,\n" + 
				"updated_at,\n" + 
				"version,\n" + 
				"deleted_by,\n" + 
				"deleted_at,\n" + 
				"image_id,\n" + 
				"image_path\n" + 
				"from ramens\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"where shop_id =:shopId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("shopId", shopId);
		return template.query(sql, param, RAMEN_ROW_MAPPER);
	}
}
