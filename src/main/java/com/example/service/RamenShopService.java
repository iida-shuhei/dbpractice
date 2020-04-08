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
}
