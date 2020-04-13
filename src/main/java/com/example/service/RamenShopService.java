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
	
	public RamenShop load(Integer shopId) {
		return ramenShopRepository.load(shopId);
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
