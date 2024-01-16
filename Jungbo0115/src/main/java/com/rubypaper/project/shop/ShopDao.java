package com.rubypaper.project.shop;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopDao {
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
