package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;
import com.example.domain.RamenImage;
import com.example.domain.RamenShop;
import com.example.domain.RamenShopTime;
import com.example.domain.Review;
import com.example.domain.User;

/**
 * レビューを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class ReviewRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 全件検索用RowMapper.
	 * 
	 */
	private static final RowMapper<Review> REVIEW_ROW_MAPPER = (rs,i) -> {
		Review review = new Review();
		review.setReviewId(rs.getInt("review_id"));
		review.setShopId(rs.getInt("r_shop_id"));
		review.setUserId(rs.getInt("r_user_id"));
		review.setRamenName(rs.getString("ramen_name"));
		review.setRamenPrice(rs.getInt("ramen_price"));
		review.setRamenImagePathId(rs.getInt("ramen_image_path_id"));
		review.setCreatedBy(rs.getString("r_created_by"));
		review.setCreatedAt(rs.getTimestamp("r_created_at"));
		review.setUpdatedBy(rs.getString("r_updated_by"));
		review.setUpdatedAt(rs.getTimestamp("r_updated_at"));
		review.setVersion(rs.getInt("r_version"));
		review.setDeletedBy(rs.getString("r_deleted_by"));
		review.setDeletedAt(rs.getTimestamp("r_deleted_at"));
		
		RamenImage ramenImage = new RamenImage();
		ramenImage.setImageId(rs.getInt("image_id"));
		ramenImage.setImagePath(rs.getString("image_path"));
		review.setRamenImage(ramenImage);
		
		RamenShop ramenShop = new RamenShop();
		ramenShop.setShopId(rs.getInt("s_shop_id"));
		ramenShop.setShopName(rs.getString("shop_name"));
		ramenShop.setZipcode(rs.getString("zipcode"));
		ramenShop.setPrefecture(rs.getString("prefecture"));
		ramenShop.setCity(rs.getString("city"));
		ramenShop.setOther(rs.getString("other"));
		ramenShop.setHolidays(rs.getString("holidays"));
		ramenShop.setCreatedBy(rs.getString("s_created_by"));
		ramenShop.setCreatedAt(rs.getTimestamp("s_created_at"));
		ramenShop.setUpdatedBy(rs.getString("s_updated_by"));
		ramenShop.setUpdatedAt(rs.getTimestamp("s_updated_at"));
		ramenShop.setVersion(rs.getInt("s_version"));
		ramenShop.setDeletedBy(rs.getString("s_deleted_by"));
		ramenShop.setDeletedAt(rs.getTimestamp("s_deleted_at"));
		review.setRamenShop(ramenShop);
		
		User user = new User();
		user.setUserId(rs.getInt("u_user_id"));
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setUserIconId(rs.getInt("user_icon_id"));
		user.setUserRankId(rs.getInt("user_rank_id"));
		user.setCreatedBy(rs.getString("u_created_by"));
		user.setCreatedAt(rs.getTimestamp("u_created_at"));
		user.setUpdatedBy(rs.getString("u_updated_by"));
		user.setUpdatedAt(rs.getTimestamp("u_updated_at"));
		user.setVersion(rs.getInt("u_version"));
		user.setDeletedBy(rs.getString("u_deleted_by"));
		user.setDeletedAt(rs.getTimestamp("u_deleted_at"));
		review.setUser(user);
				
		return review;
	};
	
	
	/**
	 * 詳細用RowMapper
	 */
	private static final RowMapper<Review> REVIEW__DETAIL_ROW_MAPPER = (rs,i) -> {
		Review review = new Review();
		review.setReviewId(rs.getInt("review_id"));
		review.setShopId(rs.getInt("r_shop_id"));
		review.setUserId(rs.getInt("r_user_id"));
		review.setRamenName(rs.getString("ramen_name"));
		review.setRamenPrice(rs.getInt("ramen_price"));
		review.setRamenImagePathId(rs.getInt("ramen_image_path_id"));
		review.setCreatedBy(rs.getString("r_created_by"));
		review.setCreatedAt(rs.getTimestamp("r_created_at"));
		review.setUpdatedBy(rs.getString("r_updated_by"));
		review.setUpdatedAt(rs.getTimestamp("r_updated_at"));
		review.setVersion(rs.getInt("r_version"));
		review.setDeletedBy(rs.getString("r_deleted_by"));
		review.setDeletedAt(rs.getTimestamp("r_deleted_at"));
		
		RamenImage ramenImage = new RamenImage();
		ramenImage.setImageId(rs.getInt("image_id"));
		ramenImage.setImagePath(rs.getString("image_path"));
		review.setRamenImage(ramenImage);
		
		RamenShop ramenShop = new RamenShop();
		ramenShop.setShopId(rs.getInt("s_shop_id"));
		ramenShop.setShopName(rs.getString("shop_name"));
		ramenShop.setZipcode(rs.getString("zipcode"));
		ramenShop.setPrefecture(rs.getString("prefecture"));
		ramenShop.setCity(rs.getString("city"));
		ramenShop.setOther(rs.getString("other"));
		ramenShop.setHolidays(rs.getString("holidays"));
		ramenShop.setCreatedBy(rs.getString("s_created_by"));
		ramenShop.setCreatedAt(rs.getTimestamp("s_created_at"));
		ramenShop.setUpdatedBy(rs.getString("s_updated_by"));
		ramenShop.setUpdatedAt(rs.getTimestamp("s_updated_at"));
		ramenShop.setVersion(rs.getInt("s_version"));
		ramenShop.setDeletedBy(rs.getString("s_deleted_by"));
		ramenShop.setDeletedAt(rs.getTimestamp("s_deleted_at"));
		review.setRamenShop(ramenShop);
		
		RamenShopTime ramenShopTime = new RamenShopTime();
		ramenShopTime.setShopId(rs.getInt("t_shop_id"));
		ramenShopTime.setDays(rs.getString("days"));
		ramenShopTime.setNoonStartTime(rs.getString("noon_start_time"));
		ramenShopTime.setNoonEndTime(rs.getString("noon_end_time"));
		ramenShopTime.setNightStartTime(rs.getString("night_start_time"));
		ramenShopTime.setNightEndTime(rs.getString("night_end_time"));
		ramenShopTime.setOtherTime(rs.getString("other_time"));
		ramenShop.setRamenShopTime(ramenShopTime);
		
		User user = new User();
		user.setUserId(rs.getInt("u_user_id"));
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setUserIconId(rs.getInt("user_icon_id"));
		user.setUserRankId(rs.getInt("user_rank_id"));
		user.setCreatedBy(rs.getString("u_created_by"));
		user.setCreatedAt(rs.getTimestamp("u_created_at"));
		user.setUpdatedBy(rs.getString("u_updated_by"));
		user.setUpdatedAt(rs.getTimestamp("u_updated_at"));
		user.setVersion(rs.getInt("u_version"));
		user.setDeletedBy(rs.getString("u_deleted_by"));
		user.setDeletedAt(rs.getTimestamp("u_deleted_at"));
		review.setUser(user);
		
		return review;
	};
	
	//RESULTSETEXTRACTOR
	private static final ResultSetExtractor<List<Review>> REVIEWS_RESULT_SET_EXTRACTOR = (rs) -> {
		List<Review> reviewList = new ArrayList<>();
		List<Comment> commentList = null;
		int preId = 0;
		
		while(rs.next()) {
			int nowId = rs.getInt("r_review_id");
			
			if(nowId != preId) {
				Review review = new Review();
				review.setReviewId(nowId);
				review.setShopId(rs.getInt("r_shop_id"));
				review.setUserId(rs.getInt("r_user_id"));
				review.setRamenName(rs.getString("ramen_name"));
				review.setRamenPrice(rs.getInt("ramen_price"));
				review.setRamenImagePathId(rs.getInt("ramen_image_path_id"));
				review.setCreatedBy(rs.getString("r_created_by"));
				review.setCreatedAt(rs.getTimestamp("r_created_at"));
				review.setUpdatedBy(rs.getString("r_updated_by"));
				review.setUpdatedAt(rs.getTimestamp("r_updated_at"));
				review.setVersion(rs.getInt("r_version"));
				review.setDeletedBy(rs.getString("r_deleted_by"));
				review.setDeletedAt(rs.getTimestamp("r_deleted_at"));
				
				RamenImage ramenImage = new RamenImage();
				ramenImage.setImageId(rs.getInt("image_id"));
				ramenImage.setImagePath(rs.getString("image_path"));
				review.setRamenImage(ramenImage);
				
				RamenShop ramenShop = new RamenShop();
				ramenShop.setShopId(rs.getInt("s_shop_id"));
				ramenShop.setShopName(rs.getString("shop_name"));
				ramenShop.setZipcode(rs.getString("zipcode"));
				ramenShop.setPrefecture(rs.getString("prefecture"));
				ramenShop.setCity(rs.getString("city"));
				ramenShop.setOther(rs.getString("other"));
				ramenShop.setHolidays(rs.getString("holidays"));
				ramenShop.setCreatedBy(rs.getString("s_created_by"));
				ramenShop.setCreatedAt(rs.getTimestamp("s_created_at"));
				ramenShop.setUpdatedBy(rs.getString("s_updated_by"));
				ramenShop.setUpdatedAt(rs.getTimestamp("s_updated_at"));
				ramenShop.setVersion(rs.getInt("s_version"));
				ramenShop.setDeletedBy(rs.getString("s_deleted_by"));
				ramenShop.setDeletedAt(rs.getTimestamp("s_deleted_at"));
				review.setRamenShop(ramenShop);
				
				User user = new User();
				user.setUserId(rs.getInt("u_user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setUserIconId(rs.getInt("user_icon_id"));
				user.setUserRankId(rs.getInt("user_rank_id"));
				user.setCreatedBy(rs.getString("u_created_by"));
				user.setCreatedAt(rs.getTimestamp("u_created_at"));
				user.setUpdatedBy(rs.getString("u_updated_by"));
				user.setUpdatedAt(rs.getTimestamp("u_updated_at"));
				user.setVersion(rs.getInt("u_version"));
				user.setDeletedBy(rs.getString("u_deleted_by"));
				user.setDeletedAt(rs.getTimestamp("u_deleted_at"));
				review.setUser(user);
				
				commentList = new ArrayList<>();
				review.setCommentList(commentList);
				reviewList.add(review);
			}
			if(rs.getInt("comment_id") != 0) {
				Comment comment = new Comment();
				comment.setCommentId(rs.getInt("comment_id"));
				comment.setCommentName(rs.getString("comment_name"));
				comment.setContent(rs.getString("content"));
				comment.setReviewId(rs.getInt("c_review_id"));
				commentList.add(comment);
			}
			preId = nowId;
		}
		return reviewList;
	};
	
	private SimpleJdbcInsert insert;
	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert =
		new SimpleJdbcInsert((JdbcTemplate)template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("reviews");
		insert = withTableName.usingGeneratedKeyColumns("review_id");
	}
	
	/**
	 * レビューを登録する.
	 * 
	 * @param review 記事
	 */
	public Review insert(Review review) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(review);
		Number key = insert.executeAndReturnKey(param);
		review.setReviewId(key.intValue());
		return review;
	}
	
	/**
	 * ログインしているユーザーのレビュー一覧を取得する.
	 * 
	 * @return 記事
	 */
	public List<Review> findByLoginUser(Integer userId, Integer start) {
		String sql = "select r.review_id r_review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"u.user_id u_user_id,\n" + 
				"user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at,\n" + 
				"comment_id, comment_name, content, c.review_id c_review_id\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"left join comments as c\n" +
				"on r.review_id = c.review_id\n" +
				"where r.deleted_by is null and r.deleted_at is null and r.user_id =:userId order by r.review_id desc limit 8 offset :start";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("start", start);
		return template.query(sql, param, REVIEWS_RESULT_SET_EXTRACTOR);
	}
	
	/**
	 * ユーザーのレビュー一覧を取得する.
	 * 
	 * @return 記事
	 */
	public List<Review> findAll(Integer start) {
		String sql = "select r.review_id r_review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"u.user_id u_user_id,\n" + 
				"coalesce(user_name, '退会済みユーザー') as user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at,\n" + 
				"comment_id, comment_name, content, c.review_id c_review_id\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"left join comments as c\n" +
				"on r.review_id = c.review_id\n" +
				"where r.deleted_by is null and r.deleted_at is null order by r.review_id desc limit 8 offset :start";
		SqlParameterSource param = new MapSqlParameterSource().addValue("start", start);
		return template.query(sql, param, REVIEWS_RESULT_SET_EXTRACTOR);
	}
	
	/**
	 * ユーザーのお気に入りレビュー一覧を取得する.
	 * 
	 * @return 記事
	 */
	public List<Review> findFavoriteReview(Integer userId, Integer start) {
		String sql = "select r.review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"f.id, f.user_id f_user_id,\n" + 
				"f.review_id f_review_id,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"u.user_id u_user_id,\n" + 
				"coalesce(user_name, '退会済みユーザー') as user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join favorites as f\n" + 
				"on r.review_id = f.review_id\n" +
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"where r.deleted_by is null and r.deleted_at is null and f.user_id = :userId order by r.review_id desc limit 8 offset :start";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("start", start);
		return template.query(sql, param, REVIEW_ROW_MAPPER);
	}
	
	/**
	 * レビュー詳細を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return レビュー詳細
	 */
	public Review load(Integer reviewId) {
		String sql = "select review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"u.user_id u_user_id,\n" + 
				"coalesce(user_name, '退会済みユーザー') as user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +  
				"where review_id =:reviewId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.queryForObject(sql, param, REVIEW_ROW_MAPPER);
	}
	
	/**
	 * 月曜日の営業時間を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return 月曜日の営業時間
	 */
	public List<Review> findByMonday(Integer reviewId) {
		String sql = "select review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time, " +
				"u.user_id u_user_id,\n" + 
				"user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops_times as t\n" + 
				"on r.shop_id = t.shop_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"where review_id =:reviewId\n" +
				"and days = '月曜日'\n" +
				"order by noon_start_time,noon_end_time,night_start_time,night_end_time";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param, REVIEW__DETAIL_ROW_MAPPER);
	}
	
	/**
	 * 火曜日の営業時間を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return 火曜日の営業時間
	 */
	public List<Review> findByTuesday(Integer reviewId) {
		String sql = "select review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time, " +
				"u.user_id u_user_id,\n" + 
				"user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops_times as t\n" + 
				"on r.shop_id = t.shop_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"where review_id =:reviewId\n" +
				"and days = '火曜日'\n" +
				"order by noon_start_time,noon_end_time,night_start_time,night_end_time";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param, REVIEW__DETAIL_ROW_MAPPER);
	}
	
	/**
	 * 水曜日の営業時間を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return 水曜日の営業時間
	 */
	public List<Review> findByWednesday(Integer reviewId) {
		String sql = "select review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time, " +
				"u.user_id u_user_id,\n" + 
				"user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops_times as t\n" + 
				"on r.shop_id = t.shop_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"where review_id =:reviewId\n" +
				"and days = '水曜日'\n" +
				"order by noon_start_time,noon_end_time,night_start_time,night_end_time";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param, REVIEW__DETAIL_ROW_MAPPER);
	}
	
	/**
	 * 木曜日の営業時間を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return 木曜日の営業時間
	 */
	public List<Review> findByThursday(Integer reviewId) {
		String sql = "select review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time, " +
				"u.user_id u_user_id,\n" + 
				"user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops_times as t\n" + 
				"on r.shop_id = t.shop_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"where review_id =:reviewId\n" +
				"and days = '木曜日'\n" +
				"order by noon_start_time,noon_end_time,night_start_time,night_end_time";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param, REVIEW__DETAIL_ROW_MAPPER);
	}
	
	/**
	 * 金曜日の営業時間を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return 金曜日の営業時間
	 */
	public List<Review> findByFriday(Integer reviewId) {
		String sql = "select review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time, " +
				"u.user_id u_user_id,\n" + 
				"user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops_times as t\n" + 
				"on r.shop_id = t.shop_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"where review_id =:reviewId\n" +
				"and days = '金曜日'\n" +
				"order by noon_start_time,noon_end_time,night_start_time,night_end_time";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param, REVIEW__DETAIL_ROW_MAPPER);
	}
	
	/**
	 * 土曜日の営業時間を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return 土曜日の営業時間
	 */
	public List<Review> findBySaturday(Integer reviewId) {
		String sql = "select review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time, " +
				"u.user_id u_user_id,\n" + 
				"user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops_times as t\n" + 
				"on r.shop_id = t.shop_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"where review_id =:reviewId\n" +
				"and days = '土曜日'\n" +
				"order by noon_start_time,noon_end_time,night_start_time,night_end_time";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param, REVIEW__DETAIL_ROW_MAPPER);
	}
	
	/**
	 * 日曜日の営業時間を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return 日曜日の営業時間
	 */
	public List<Review> findBySunday(Integer reviewId) {
		String sql = "select review_id, \n" +
				"r.shop_id r_shop_id, \n" +
				"r.user_id r_user_id, \n" +
				"ramen_name,\n" + 
				"ramen_price,\n" + 
				"ramen_image_path_id,\n" + 
				"r.created_by r_created_by,\n" + 
				"r.created_at r_created_at,\n" + 
				"r.updated_by r_updated_by,\n" + 
				"r.updated_at r_updated_at,\n" + 
				"r.version r_version,\n" + 
				"r.deleted_by r_deleted_by,\n" + 
				"r.deleted_at r_deleted_at,\n" + 
				"image_id,\n" + 
				"image_path,\n" + 
				"s.shop_id s_shop_id, \n" + 
				"shop_name, \n" + 
				"zipcode,\n" + 
				"prefecture,\n" + 
				"city,\n" + 
				"other,\n" + 
				"holidays,\n" + 
				"s.created_by s_created_by,\n" + 
				"s.created_at s_created_at,\n" + 
				"s.updated_by s_updated_by,\n" + 
				"s.updated_at s_updated_at,\n" + 
				"s.version s_version,\n" + 
				"s.deleted_by s_deleted_by,\n" + 
				"s.deleted_at s_deleted_at,\n" + 
				"t.shop_id t_shop_id, \n" + 
				"days, \n" + 
				"noon_start_time,\n" + 
				"noon_end_time,\n" + 
				"night_start_time,\n" + 
				"night_end_time,\n" + 
				"other_time, " +
				"u.user_id u_user_id,\n" + 
				"user_name,\n" + 
				"password,\n" + 
				"user_icon_id,\n" + 
				"user_rank_id,\n" + 
				"u.created_by u_created_by,\n" + 
				"u.created_at u_created_at,\n" + 
				"u.updated_by u_updated_by,\n" + 
				"u.updated_at u_updated_at,\n" + 
				"u.version u_version,\n" + 
				"u.deleted_by u_deleted_by,\n" + 
				"u.deleted_at u_deleted_at\n" + 
				"from reviews as r\n" + 
				"left join ramen_images\n" + 
				"on ramen_image_path_id = image_id\n" +
				"left join ramen_shops_times as t\n" + 
				"on r.shop_id = t.shop_id\n" +
				"left join ramen_shops as s\n" + 
				"on r.shop_id = s.shop_id\n" +
				"left join users as u\n" +
				"on r.user_id = u.user_id\n" +
				"where review_id =:reviewId\n" +
				"and days = '日曜日'\n" +
				"order by noon_start_time,noon_end_time,night_start_time,night_end_time";
		SqlParameterSource param = new MapSqlParameterSource().addValue("reviewId", reviewId);
		return template.query(sql, param, REVIEW__DETAIL_ROW_MAPPER);
	}
	
	/**
	 * ログインしているユーザーの記事数を取得する.
	 * 
	 * @param userId ユーザーID
	 * @return レビュー数
	 */
	public Integer countUserReview(Integer userId) {
		String sql = "select count(*) from reviews where deleted_by is null and deleted_at is null and user_id =:userId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		return template.queryForObject(sql, param, Integer.class);
	}
	
	/**
	 * ログインしているユーザー以外の記事数を取得する.
	 * 
	 * @param userId ユーザーID
	 * @return レビュー数
	 */
	public Integer countAllReview(Integer userId) {
		String sql = "select count(*) from reviews where deleted_by is null and deleted_at is null";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		return template.queryForObject(sql, param, Integer.class);
	}
	
	/**
	 * ログインしているユーザーのお気に入り記事数を取得する.
	 * 
	 * @param userId ユーザーID
	 * @return お気に入り数
	 */
	public Integer countFavoriteReview(Integer userId) {
		String sql = "select count(*) from favorites where user_id =:userId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		return template.queryForObject(sql, param, Integer.class);
	}
	
	/**
	 * レビューを削除する.
	 * 
	 * @param review レビュー
	 */
	public void delete(Review review) {
		String sql = "update reviews set deleted_by =:deletedBy, deleted_at =:deletedAt where review_id =:reviewId and user_id =:userId";
		SqlParameterSource param = new BeanPropertySqlParameterSource(review);
		template.update(sql, param);
	}
}