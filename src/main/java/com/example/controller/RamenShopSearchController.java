package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.RamenShop;
import com.example.repository.RamenShopRepository;

/**
 * ラーメン店舗を管理するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/ramenShopSearch")
public class RamenShopSearchController {

	@Autowired
	private RamenShopRepository ramenShopRepository;
	
	/**
	 * トップページを表示.
	 * 
	 * @param model モデル
	 * @return トップページ情報
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<RamenShop> ramenShopList = ramenShopRepository.findAll();
		model.addAttribute("ramenShopList", ramenShopList);
		return "ramenShop_search";
	}
	
	/**
	 * ラーメン店舗を検索する.
	 * 
	 * @param shopName ラーメン店舗名
	 * @param model モデル
	 * @return ラーメン店舗検索サイト
	 */
	@RequestMapping("/search")
	public String search(String shopName,Model model) {
		List<RamenShop> ramenShopList = ramenShopRepository.findByShopName(shopName);
		if(shopName == null || ramenShopList.isEmpty()) {
			List<RamenShop> ramenShopList1 = ramenShopRepository.findAll();
			model.addAttribute("ramenShopList", ramenShopList1);
			model.addAttribute("message", "該当するラーメン店舗はまだ登録されていません");
		} else {
			model.addAttribute("ramenShopList", ramenShopList);
		}
		return "ramenShop_search";
	}
}
