package com.springboot.jungbo0129.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

  @Autowired
  private ShopDao dao;

  // Product

  @Override
  public List<ProductVO> productList(ProductVO vo) {
    return dao.productList(vo);
  }

  @Override
  public ProductVO product(ProductVO vo) {
    return dao.product(vo);
  }

  @Override
  public void productInsert(ProductVO vo) {
    dao.productInsert(vo);
  }

  // Cart

  @Override
  public CartVO cartCheck(CartVO vo) {
    return dao.cartCheck(vo);
  }

  @Override
  public void cartInsert(CartVO vo) {
    dao.cartInsert(vo);
  }

  @Override
  public void cartUpdate(CartVO vo) {
    dao.cartUpdate(vo);
  }

  @Override
  public List<CartVO> cartList(CartVO vo) {
    return dao.cartList(vo);
  }

  @Override
  public void cartDeleteAll() {
    dao.cartDeleteAll();
  }

  @Override
  public int order_idx() {
    return dao.order_idx();
  }

  // Order

  @Override
  public void orderAll(OrderVO vo) {
    dao.orderAll(vo);
  }

  @Override
  public List<OrderVO> orderList(OrderVO vo) {
    return dao.orderList(vo);
  }
}
