package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.domain.RamenShop;
import com.example.form.ArticleRegisterForm;
import com.example.repository.RamenImageRepository;
import com.example.repository.RamenRepository;
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
	public RamenShopTimeRepository ramenShopTimeRepository;
	
	@Autowired
	public RamenRepository ramenRepository;
	
	@Autowired
	public RamenImageRepository ramenImageRepository;
	
	public void insert(ArticleRegisterForm articleRegisterForm) {
//		Article article = new Article();
//		article.setUserId(articleRegisterForm.getUserId());
//		article.setShopId(ramenShop.getShopId);
		
		RamenShop ramenShop = new RamenShop();
		ramenShop.setShopName(articleRegisterForm.getShopName());
		ramenShop.setPrefecture(articleRegisterForm.getPrefecture());
		ramenShop.setCity(articleRegisterForm.getCity());
		ramenShop.setOther(articleRegisterForm.getOther());
		ramenShop.setHolidays(articleRegisterForm.getHolidays());
		
	}
}
