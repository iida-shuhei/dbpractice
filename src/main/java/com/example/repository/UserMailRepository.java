package com.example.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
}
