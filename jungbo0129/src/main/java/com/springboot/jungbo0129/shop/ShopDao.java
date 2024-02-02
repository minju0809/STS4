package com.springboot.jungbo0129.shop;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopDao {
  List<ProductVO> productList(ProductVO vo);

  void productInsert(ProductVO vo);
}
