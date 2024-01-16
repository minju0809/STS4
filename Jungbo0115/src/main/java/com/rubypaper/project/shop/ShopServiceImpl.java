package com.rubypaper.project.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao dao;
	
	@Override
	public List<ProductVO> getShopList(ProductVO vo) {
		return dao.getShopList(vo);
	}
	
	@Override
	public int getId() {
		return dao.getId();
	}

	@Override
	public void insert(ProductVO vo) {
		dao.insert(vo);
	}

}
