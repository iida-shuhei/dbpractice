package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.RamenShop;
import com.example.repository.RamenShopRepository;

@Service
@Transactional
public class RamenShopService {

	@Autowired
	private RamenShopRepository ramenShopRepository;
	
	
	
//	public List<RamenShop> findAll() {
//		return ramenShopRepository.findAll();
//	}
	
	
	/**
	 * ラーメン店舗情報を検索する.
	 * @param shopId
	 * @return
	 */
	public RamenShop load(Integer shopId) {
		return ramenShopRepository.load(shopId);
	}
	
	
    /**
     * ラーメン店舗情報と月曜日の営業時間を検索.
     * @param shopId
     * @return
     */
    public List<RamenShop> findByMonday(Integer shopId){
    	return ramenShopRepository.findByMonday(shopId);
    	
    }
    
    
    /**
     * ラーメン店舗情報と火曜日の営業時間を検索.
     * @param shopId
     * @return
     */
    public List<RamenShop> findByTuesday(Integer shopId){
    	return ramenShopRepository.findByTuesday(shopId);
    }
    
    /**
     * ラーメン店舗情報と水曜日の営業時間を検索.
     * @param shopId
     * @return
     */
    public List<RamenShop> findByWednesday(Integer shopId){
    	return ramenShopRepository.findByWednesday(shopId);
    
    }
    
    /**
     * ラーメン店舗情報と木曜日の営業時間を検索.
     * @param shopId
     * @return
     */
    public List<RamenShop> findByThursday(Integer shopId){
    	return ramenShopRepository.findByThursday(shopId);
    }
    
    /**
     * ラーメン店舗情報と金曜日の営業時間を検索.
     * @param shopId
     * @return
     */
    public List<RamenShop> findByFriday(Integer shopId){
    	return ramenShopRepository.findByFriday(shopId);
    }
    
    /**
     * ラーメン店舗情報と 土曜日の営業時間を検索.
     * @param shopId
     * @return
     */
    public List<RamenShop> findBySaturday(Integer shopId){
    	return ramenShopRepository.findBySaturday(shopId);
    }
    
    /**
     * ラーメン店舗情報と 日曜日の営業時間を検索.
     * @param shopId
     * @return
     */
    public List<RamenShop> findBySunday(Integer shopId){
    	return ramenShopRepository.findBySunday(shopId);
    }
    
    
    
    
    
    
	
	
	
	/**
	 * オートコンプリート用にJavaScriptの配列の中身を文字列で作る.
	 * 
	 * @param ramenShopList ラーメン店舗一覧
	 * @return オートコンプリート用JavaScriptの配列の文字列
	 */
	public StringBuilder getAutoComplete(List<RamenShop> ramenShopList) {
		StringBuilder autoComplete = new StringBuilder();
		for (int i = 0; i < ramenShopList.size(); i++) {
			if(i != 0) {
				autoComplete.append(",");
			}
			RamenShop ramenShop = ramenShopList.get(i);
			autoComplete.append("\"");
			autoComplete.append(ramenShop.getShopName());
			autoComplete.append("\"");
		}
		return autoComplete;
	}
}
