package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

/**
 * ユーザーのアイコンを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class UserIconRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * ユーザーのアイコンを登録する.
	 * 
	 * @param iconImagePath ユーザーのアイコン
	 */
	public void insert(MultipartFile iconImagePath) {
		String sql = "insert into user_icons(icon_image_path)values(:iconImagePath)";
		SqlParameterSource param = new MapSqlParameterSource().addValue("iconImagePath", iconImagePath);
		template.update(sql, param);
	}
}
