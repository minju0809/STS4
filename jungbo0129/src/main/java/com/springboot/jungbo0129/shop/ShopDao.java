package com.springboot.jungbo0129.shop;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopDao {
  List<ProductVO> productList(ProductVO vo);

  ProductVO product(ProductVO vo);

  void productInsert(ProductVO vo);

  CartVO cartCheck(CartVO vo);

  void cartInsert(CartVO vo);

  void cartUpdate(CartVO vo);

  List<CartVO> cartList(CartVO vo);
}
