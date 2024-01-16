package com.rubypaper.project.shop;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopDao {
	List<ProductVO> getShopList(ProductVO vo);
	int getId();
	void insert(ProductVO vo);
}
