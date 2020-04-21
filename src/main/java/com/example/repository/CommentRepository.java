package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;
import com.example.domain.User;
import com.example.domain.UserIcon;

/**
 * コメントを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class CommentRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs,i) -> {
		Comment comment = new Comment();
		comment.setCommentId(rs.getInt("comment_id"));
		comment.setUserId(rs.getInt("c_user_id"));
		comment.setCommentName(rs.getString("comment_name"));
		comment.setContent(rs.getString("content"));
		comment.setReviewId(rs.getInt("review_id"));
		
		User user = new User();
		user.setUserId(rs.getInt("u_user_id"));
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
		
		comment.setUser(user);
		return comment;
	};
	
	/**
	 * レビューIDを検索する.
	 * 
	 * @param reviewId 記事ID
	 * @return コメント
	 */
	public List<Comment> findByReviewId(Integer reviewId){
		String sql = "select \n" + 
				"comment_id,\n" + 
				"c.user_id c_user_id,\n" + 
				"comment_name,\n" + 
				"content,\n" + 
				"review_id,\n" + 
				"u.user_id u_user_id,\n" + 
				"coalesce(user_name, '退会済みユーザー') as user_name,\n" + 
				"user_mail,\n" + 
				"password,\n" + 
				"user_icon_id, \n" + 
				"user_rank_id,\n" + 
				"created_by, \n" + 
				"created_at,\n" + 
				"updated_by,\n" + 
				"updated_at,\n" + 
				"version,\n" + 
				"deleted_by,\n" + 
				"deleted_at,\n" + 
				"icon_id, icon_image_path,rank_id,user_rank\n" + 
				"from comments as c\n" + 
				"left join users as u\n" + 
				"on c.user_id = u.user_id\n" + 
				"left join user_icons\n" + 
				"on user_icon_id = icon_id\n" + 
				"left join user_ranks\n" + 
				"on user_rank_id = rank_id\n" + 
				"where review_id =:reviewId \n" + 
				"order by comment_id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param,COMMENT_ROW_MAPPER);
	}
	
	/**
	 * コメントを挿入する.
	 * 
	 * @param comment コメント
	 */
	public void insert(Comment comment) {
		String sql = "insert into comments(comment_name,user_id, content,review_id)values(:commentName,:userId,:content,:reviewId)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
		template.update(sql, param);
	}
	
	/**
	 * コメントを削除する.
	 * 
	 * @param articleId 記事ID
	 */
	public void deleteByReviewId(Integer reviewId) {
		String deleteSql = "delete from comments where review_id=:reviewId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		template.update(deleteSql, param);
	}	
}