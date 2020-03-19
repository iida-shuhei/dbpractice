package com.example.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.domain.Ramen;
import com.example.domain.RamenImage;
import com.example.domain.RamenShop;
import com.example.domain.RamenShopTime;
import com.example.form.ArticleRegisterForm;
import com.example.repository.ArticleRepository;
import com.example.repository.RamenImageRepository;
import com.example.repository.RamenRepository;
import com.example.repository.RamenShopRepository;
import com.example.repository.RamenShopTimeRepository;

/**
 * ラーメン店舗を管理するサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class RamenShopRegisterService {

	@Autowired
	public RamenShopRepository ramenShopRepository;

	@Autowired
	public RamenShopTimeRepository ramenShopTimeRepository;

	@Autowired
	public RamenRepository ramenRepository;

	@Autowired
	public RamenImageRepository ramenImageRepository;
	
	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * 記事を登録する.
	 * ラーメン屋、ラーメン、店舗時間、ラーメン画像を登録する.
	 * 
	 * @param articleRegisterForm 記事登録フォーム
	 * @throws IOException
	 */
	public void insert(ArticleRegisterForm articleRegisterForm) throws IOException {
		RamenShop ramenShop = new RamenShop();
		ramenShop.setShopName(articleRegisterForm.getShopName());
		ramenShop.setZipcode(articleRegisterForm.getZipcode());
		ramenShop.setPrefecture(articleRegisterForm.getPrefecture());
		ramenShop.setCity(articleRegisterForm.getCity());
		ramenShop.setOther(articleRegisterForm.getOther());
		ramenShop.setHolidays(articleRegisterForm.getHolidays());
		ramenShop.setCreatedBy("飯田");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		ramenShop.setCreatedAt(timestamp);
		ramenShopRepository.insert(ramenShop);

		Article article = new Article();
		article.setUserId(1);
		article.setShopId(ramenShop.getShopId());
		articleRepository.insert(article);

		RamenShopTime ramenShopTime = new RamenShopTime();
		ramenShopTime.setShopId(ramenShop.getShopId());
		ramenShopTime.setDaysId(articleRegisterForm.getDaysId());
		ramenShopTime.setNoonStartTime(articleRegisterForm.getNoonStartTime());
		ramenShopTime.setNoonEndTime(articleRegisterForm.getNoonEndTime());
		ramenShopTime.setNightStartTime(articleRegisterForm.getNightStartTime());
		ramenShopTime.setNightEndTime(articleRegisterForm.getNightEndTime());
		ramenShopTime.setOtherTime(articleRegisterForm.getOtherTime());
		ramenShopTimeRepository.insert(ramenShopTime);

		RamenImage ramenImage = new RamenImage();
		// 画像の登録
		byte[] encoded = Base64.getEncoder().encode(articleRegisterForm.getRamenImage().getBytes());
		Charset charset = StandardCharsets.UTF_8;
		String base64 = new String(encoded, charset);
		String fileExtension = articleRegisterForm.getRamenImage().getOriginalFilename()
				.substring(articleRegisterForm.getRamenImage().getOriginalFilename().length() - 3);
		StringBuilder base64image = new StringBuilder();
		if ("jpg".equals(fileExtension)) {
			base64image.append("data:image/jpeg;base64,");
		}
		if ("png".equals(fileExtension)) {
			base64image.append("data:image/png;base64,");
		}
		base64image.append(base64);
		ramenImage.setImagePath(base64image.toString());
		ramenImageRepository.insert(ramenImage);

		Ramen ramen = new Ramen();
		ramen.setShopId(ramenShop.getShopId());
		ramen.setRamenName(articleRegisterForm.getRamenName());
		ramen.setRamenPrice(articleRegisterForm.getRamenPrice());
		ramen.setRamenImagePathId(ramenImage.getImageId());
		ramen.setCreatedBy("飯田i");
		ramen.setCreatedAt(timestamp);
		ramenRepository.insert(ramen);
	}
}
