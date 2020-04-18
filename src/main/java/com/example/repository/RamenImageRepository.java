package com.example.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.domain.RamenImage;

/**
 * ラーメン画像を管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class RamenImageRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	// Insert時に自動採番されたIDを取得する
	private SimpleJdbcInsert insert;

	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("ramen_images");
		insert = withTableName.usingGeneratedKeyColumns("image_id");
	}
	
	/**
	 * ラーメン画像を登録する.
	 * 
	 * @param ramenImage ラーメン画像
	 * @return ラーメン画像情報
	 */
	public RamenImage insert(RamenImage ramenImage) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(ramenImage);
		Number key = insert.executeAndReturnKey(param);
		ramenImage.setImageId(key.intValue());
		return ramenImage;
	}
}