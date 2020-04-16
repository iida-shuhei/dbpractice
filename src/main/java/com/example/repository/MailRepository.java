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

import com.example.domain.TmpUser;
import com.example.domain.User;

@Repository
public class MailRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<TmpUser> TmpRowMapper = new BeanPropertyRowMapper<TmpUser>(TmpUser.class);
	private static final RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
	
	
	/**
	 * tmp_usersテーブルに登録情報を一時的に挿入.
	 * @param tmpUser
	 */
	public void insert(TmpUser tmpUser) {
		String sql = "insert into tmp_users(name,mail,password,uuid)values(:name,:mail,:password,:uuid)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(tmpUser);
		template.update(sql, param);
	}
	
	//渡されてきたuuidからユーザー情報を取得.
	public TmpUser load(String uuid) {
		String sql = "select id,name,mail,password,uuid from tmp_users where uuid = :uuid";
		SqlParameterSource param = new MapSqlParameterSource().addValue("uuid", uuid);
		List<TmpUser> tmpList = template.query(sql, param , TmpRowMapper);
		if(tmpList.size()== 0) {
			return null;
		}else {
			return tmpList.get(0);
		}
	}
	//受け取ったメールアドレスからユーザー情報を検索
	public User findByMail(String mail) {
		String sql = "select user_name,user_mail,password from users where user_mail = :mail";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mail",mail);
		List<User> userList = template.query(sql,param ,rowMapper);
		if(userList.size() == 0) {
			return null;
		}else {
			return userList.get(0);
		}
	}
		
	//usersテーブルにユーザー情報を挿入.
	public void register(User user) {
		String sql = "insert into users(user_name,user_mail,password)values(:userName,:userMail,:password)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
	}
	
	//受け取ってきたuuidを元に一致するユーザー情報をtmo_usersテーブルから削除.
	public void delete(String uuid) {
		String sql = "delete from tmp_user where uuid = :uuid";
		SqlParameterSource param = new MapSqlParameterSource().addValue("uuid",uuid);
		template.update(sql, param);
	}
		

}

