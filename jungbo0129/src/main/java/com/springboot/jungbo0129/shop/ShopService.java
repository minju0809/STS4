package com.springboot.jungbo0129.shop;

import java.util.List;

public interface ShopService {
  List<ProductVO> productList(ProductVO vo);

  void productInsert(ProductVO vo);
}
