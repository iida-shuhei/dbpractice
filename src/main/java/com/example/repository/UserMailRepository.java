package com.example.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.UserMail;

/**
 * ユーザーのメールを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class UserMailRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private RowMapper<UserMail> rowMapper = new BeanPropertyRowMapper<UserMail>(UserMail.class);
	
	/**
	 * ユーザーのメールアドレスを登録する.
	 * 
	 * @param userMail ユーザーのメール情報
	 */
	public void insert(UserMail userMail) {
		String sql = "insert into user_mails(user_id, mail_type_id, mail_address)values(:userId,:mailTypeId,:mailAddress)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(userMail);
		template.update(sql, param);
	}
	
	/**
	 * メールアドレスの重複チェックをする.
	 * 
	 * @param mailAddress メールアドレス
	 * @return メールアドレス情報
	 */
	public UserMail findByEmail(String mailAddress) {
		String sql = "select user_id, mail_type_id, mail_address from user_mails where mail_address =:mailAddress";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress);
		List<UserMail> userMailList = template.query(sql, param, rowMapper);
		if(userMailList.isEmpty()) {
			return null;
		} else {
			return userMailList.get(0);
		}
	}
}
