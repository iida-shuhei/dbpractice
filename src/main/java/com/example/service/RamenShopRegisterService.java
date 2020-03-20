package com.example.service;

import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.RamenShop;
import com.example.domain.RamenShopTime;
import com.example.form.RamenShopRegisterForm;
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
	public void insert(RamenShopRegisterForm ramenShopRegisterForm){
		RamenShop ramenShop = new RamenShop();
		ramenShop.setShopName(ramenShopRegisterForm.getShopName());
		ramenShop.setZipcode(ramenShopRegisterForm.getZipcode());
		ramenShop.setPrefecture(ramenShopRegisterForm.getPrefecture());
		ramenShop.setCity(ramenShopRegisterForm.getCity());
		ramenShop.setOther(ramenShopRegisterForm.getOther());
		ramenShop.setHolidays(ramenShopRegisterForm.getHolidays());
		ramenShop.setCreatedBy("飯田");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		ramenShop.setCreatedAt(timestamp);
		ramenShopRepository.insert(ramenShop);

		RamenShopTime ramenShopTime = new RamenShopTime();
		ramenShopTime.setShopId(ramenShop.getShopId());
		ramenShopTime.setDays(ramenShopRegisterForm.getDays());
		ramenShopTime.setNoonStartTime(ramenShopRegisterForm.getNoonStartTime());
		ramenShopTime.setNoonEndTime(ramenShopRegisterForm.getNoonEndTime());
		ramenShopTime.setNightStartTime(ramenShopRegisterForm.getNightStartTime());
		ramenShopTime.setNightEndTime(ramenShopRegisterForm.getNightEndTime());
		ramenShopTime.setOtherTime(ramenShopRegisterForm.getOtherTime());
		ramenShopTimeRepository.insert(ramenShopTime);
	}
}