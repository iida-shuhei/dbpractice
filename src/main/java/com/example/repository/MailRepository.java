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

/**
 * メール認証用リポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class MailRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<TmpUser> TmpRowMapper = new BeanPropertyRowMapper<TmpUser>(TmpUser.class);
	
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
	
	//受け取ってきたuuidを元に一致するユーザー情報をtmo_usersテーブルから削除.
	public void delete(String uuid) {
		String sql = "delete from tmp_users where uuid = :uuid";
		SqlParameterSource param = new MapSqlParameterSource().addValue("uuid",uuid);
		template.update(sql, param);
	}
}