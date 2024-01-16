package com.rubypaper.project.shop;

import java.util.List;

public interface ShopService {
	List<ProductVO> getShopList(ProductVO vo);
	int getId();
	void insert(ProductVO vo);
}
