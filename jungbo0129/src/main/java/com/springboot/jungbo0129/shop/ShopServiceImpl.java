package com.springboot.jungbo0129.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

  @Autowired
  private ShopDao dao;

  @Override
  public List<ProductVO> productList(ProductVO vo) {
    return dao.productList(vo);
  }

  @Override
  public void productInsert(ProductVO vo) {
    dao.productInsert(vo);
  }
}
