package com.example.service;

import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.RamenShop;
import com.example.domain.RamenShopTime;
import com.example.form.ArticleRegisterForm;
import com.example.repository.RamenImageRepository;
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
	public RamenImageRepository ramenImageRepository;


	/**
	 * ラーメン屋を登録する.
	 * 
	 * @param articleRegisterForm 記事登録フォーム
	 * @throws IOException
	 */
	public void insert(ArticleRegisterForm articleRegisterForm){
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

		RamenShopTime ramenShopTime = new RamenShopTime();
		ramenShopTime.setShopId(ramenShop.getShopId());
		ramenShopTime.setDaysId(articleRegisterForm.getDaysId());
		ramenShopTime.setNoonStartTime(articleRegisterForm.getNoonStartTime());
		ramenShopTime.setNoonEndTime(articleRegisterForm.getNoonEndTime());
		ramenShopTime.setNightStartTime(articleRegisterForm.getNightStartTime());
		ramenShopTime.setNightEndTime(articleRegisterForm.getNightEndTime());
		ramenShopTime.setOtherTime(articleRegisterForm.getOtherTime());
		ramenShopTimeRepository.insert(ramenShopTime);
	}
}