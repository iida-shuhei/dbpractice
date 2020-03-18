package com.example.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
		insert = withTableName.usingGeneratedKeyColumns("ramen_image_path_id");
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
}
