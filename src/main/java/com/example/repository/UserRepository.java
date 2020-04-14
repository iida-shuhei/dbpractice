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

import com.example.domain.User;
import com.example.domain.UserIcon;
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
	
	//rowMapper破壊神
	private RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
	
	private static final RowMapper<User> USER_ROW_MAPPER = (rs,i) -> {
		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setUserName(rs.getString("user_name"));
		user.setUserMail(rs.getString("user_mail"));
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
		
		UserIcon userIcon = new UserIcon();
		userIcon.setIconId(rs.getInt("icon_id"));
		userIcon.setIconImagePath(rs.getString("icon_image_path"));
		user.setUserIcon(userIcon);
		
		UserRank userRank = new UserRank();
		userRank.setRankId(rs.getInt("rank_id"));
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
	public void insert(User user) {
		String sql = "insert into users(user_name,user_mail,password,user_icon_id,user_rank_id,created_by,created_at,updated_by,updated_at,deleted_by,deleted_at,version)values(:userName,:userMail,:password,:userIconId,:userRankId,:createdBy,:createdAt,:updatedBy,:updatedAt,:deletedBy,:deletedAt,:version)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
	}
	
	/**
	 * メールアドレスからユーザー情報を検索する.
	 * 
	 * @param userMail メールアドレス
	 * @return ユーザー情報
	 */
	public User findByUserMail(String userMail) {
		String sql = "select user_id,user_name,user_mail,password,user_icon_id,user_rank_id,created_by,created_at,updated_by,updated_at,deleted_by,deleted_at,version from users where user_mail =:userMail";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userMail", userMail);
		List<User> userList = template.query(sql, param,rowMapper);
		if(userList.isEmpty()) {
			return null;
		} else {
			return userList.get(0);
		}
	}
	
	/**
	 * ユーザーIDからユーザー詳細を検索する.
	 * 
	 * @param userId userId
	 * @return ユーザー詳細
	 */
	public User findByUserId(Integer userId) {
		String sql = "select user_id,"
				+ "user_name,"
				+ "user_mail,"
				+ "password,"
				+ "user_icon_id,"
				+ "user_rank_id,"
				+ "created_by,"
				+ "created_at,"
				+ "updated_by,"
				+ "updated_at,"
				+ "deleted_by,"
				+ "deleted_at,"
				+ "version,"
				+ "icon_id,"
				+ "icon_image_path,"
				+ "rank_id,"
				+ "user_rank "
				+ "from users "
				+ "left join user_icons "
				+ "on user_icon_id = icon_id "
				+ "left join user_ranks "
				+ "on user_rank_id = rank_id "
				+ "where user_id =:userId;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		return template.queryForObject(sql, param, USER_ROW_MAPPER);
	}
	
	/**
	 * ユーザー情報を更新する.
	 * 
	 * @param user ユーザー
	 */
	public void update(User user) {
		String sql = "update users set user_name =:userName, user_mail =:userMail, password =:password, user_icon_id =:userIconId, updated_by =:updatedBy, updated_at =:updatedAt,version = version + 1 where user_id =:userId";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
	}
	
	/**
	 * ユーザーIDからランクIDを更新する
	 * 
	 * @param userId ユーザーID
	 * @param userRankId ランクID
	 */
	public void updateUserRank(Integer userId, Integer userRankId) {
		String sql = "update users set user_rank_id =:userRankId where user_id =:userId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("userRankId", userRankId);
		template.update(sql, param);
	}
}