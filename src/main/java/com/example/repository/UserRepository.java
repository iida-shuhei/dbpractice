package com.example.repository;

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

import com.example.domain.User;
import com.example.domain.UserIcon;
import com.example.domain.UserMail;
import com.example.domain.UserRank;

/**
 * ユーザーを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	//Insert時に自動採番されたIDを取得する
	private SimpleJdbcInsert insert;
	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate)template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("users");
		insert = withTableName.usingGeneratedKeyColumns("user_id");
	}
	
	private static final RowMapper<User> USER_ROW_MAPPER = (rs,i) -> {
		User user = new User();
		user.setUserId(rs.getInt("u_user_id"));
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setUserIconId(rs.getInt("user_icon_id"));
		user.setUserRankId(rs.getInt("user_rank_id"));
		user.setCreatedBy(rs.getString("created_by"));
		user.setCreatedAt(rs.getTimestamp("created_at"));
		user.setUpdatedBy(rs.getString("updated_by"));
		user.setUpdatedAt(rs.getTimestamp("updated_at"));
		user.setVersion(rs.getInt("version"));
		user.setDeletedBy(rs.getString("deleted_by"));
		user.setDeletedAt(rs.getTimestamp("deleted_at"));
		
		UserMail userMail = new UserMail();
		userMail.setUserId(rs.getInt("m_user_id"));
		userMail.setMailTypeId(rs.getInt("mail_type_id"));
		userMail.setMailAddress(rs.getString("mail_address"));
		user.setUserMail(userMail);
		
		UserIcon userIcon = new UserIcon();
		userIcon.setIconId(rs.getInt("icon_id"));
		userIcon.setIconImagePath(rs.getString("icon_image_path"));
		user.setUserIcon(userIcon);
		
		UserRank userRank = new UserRank();
		userRank.setRankId(rs.getInt("r_rank_id"));
		userRank.setRank(rs.getString("user_rank"));
		user.setUserRank(userRank);
		return user;
	};
	
	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param user ユーザー
	 * @return ユーザー情報
	 */
	public User insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		Number key = insert.executeAndReturnKey(param);
		user.setUserId(key.intValue());
		return user;
	}
	
	/**
	 * ユーザーIDとランクIDからユーザー詳細を検索する.
	 * 
	 * @param user_id ユーザーID
	 * @param rank_id ランクID
	 * @return ユーザー詳細
	 */
	public User load(Integer userId) {
		String sql = "select u.user_id u_user_id,\n" + 
				"user_name, \n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"created_by,\n" + 
				"created_at,\n" + 
				"updated_by,\n" + 
				"updated_at,\n" + 
				"version,\n" + 
				"deleted_by,\n" + 
				"deleted_at,\n" + 
				"m.user_id m_user_id,\n" + 
				"mail_type_id,\n" + 
				"mail_address,\n" + 
				"icon_id,\n" + 
				"icon_image_path,\n" + 
				"r.rank_id r_rank_id,\n" + 
				"user_rank\n" + 
				"from users as u\n" + 
				"left join user_mails as m\n" + 
				"on u.user_id = m.user_id\n" + 
				"left join user_icons as i\n" + 
				"on u.user_icon_id = i.icon_id\n" + 
				"left join user_ranks as r\n" + 
				"on u.user_rank_id = r.rank_id\n" + 
				"where u.user_id =:userId;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		return template.queryForObject(sql, param, USER_ROW_MAPPER);
	}
}