package com.rubypaper.project.shop;

import java.util.List;

public interface ShopService {
	List<ProductVO> getShopList(ProductVO vo);
	ProductVO getShop(ProductVO vo);
	int getId();
	void insert(ProductVO vo);
	
	CartVO getProductId(CartVO vo);
	void cartInsert(CartVO vo);
	void cartUpdate(CartVO vo);
	void cartDelete(CartVO vo);
	List<CartVO> getCartList(CartVO vo);
}
