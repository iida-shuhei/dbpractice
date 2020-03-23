package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Ramen;
import com.example.domain.RamenShop;
import com.example.repository.RamenRepository;
import com.example.repository.RamenShopRepository;

@Controller
@RequestMapping("/ramenShop")
public class RamenShopController {

	@Autowired
	private RamenShopRepository ramenShopRepository;
	
	@Autowired
	private RamenRepository ramenRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<RamenShop> ramenShopList = ramenShopRepository.findAll();
		for (RamenShop ramenShop : ramenShopList) {
			List<Ramen> ramenList = ramenRepository.findByShopId(ramenShop.getShopId());
			ramenShop.setRamenList(ramenList);
		}
		model.addAttribute("ramenShopList", ramenShopList);
		return "ramenShop_search";
	}
	
	@RequestMapping("/search")
	public String index(String shopName,Model model) {
		List<RamenShop> ramenShopList = ramenShopRepository.findByShopName(shopName);
		if(shopName == null || ramenShopList.isEmpty()) {
			List<RamenShop> ramenShopList1 = ramenShopRepository.findAll();
			for (RamenShop ramenShop : ramenShopList1) {
				List<Ramen> ramenList = ramenRepository.findByShopId(ramenShop.getShopId());
				ramenShop.setRamenList(ramenList);
			}
			model.addAttribute("ramenShopList", ramenShopList1);
			model.addAttribute("message", "該当するラーメン店舗はまだ登録されていません");
		} else {
			for (RamenShop ramenShop : ramenShopList) {
				List<Ramen> ramenList = ramenRepository.findByShopId(ramenShop.getShopId());
				ramenShop.setRamenList(ramenList);
			}
			model.addAttribute("ramenShopList", ramenShopList);
		}
		return "ramenShop_search";
	}
}
