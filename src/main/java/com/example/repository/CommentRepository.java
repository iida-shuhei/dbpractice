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
		comment.setCommentName(rs.getString("comment_name"));
		comment.setContent(rs.getString("content"));
		comment.setReviewId(rs.getInt("review_id"));
		return comment;
	};
	
	/**
	 * レビューIDを検索する.
	 * 
	 * @param reviewId 記事ID
	 * @return コメント
	 */
	public List<Comment> findByReviewId(Integer reviewId){
		String sql = "select comment_id,comment_name,content,review_id from comments where review_id =:reviewId order by comment_id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param,COMMENT_ROW_MAPPER);
	}
	
	/**
	 * コメントを挿入する.
	 * 
	 * @param comment コメント
	 */
	public void insert(Comment comment) {
		String sql = "insert into comments(comment_name,content,review_id)values(:commentName,:content,:reviewId)";
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