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
	public ProductVO getShop(ProductVO vo) {
		return dao.getShop(vo);
	}
	
	@Override
	public int getId() {
		return dao.getId();
	}

	@Override
	public void insert(ProductVO vo) {
		dao.insert(vo);
	}
	
	
	@Override
	public CartVO getProductId(CartVO vo) {
		return dao.getProductId(vo);
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
	public void cartDelete(CartVO vo) {
		dao.cartDelete(vo);
	}

	@Override
	public List<CartVO> getCartList(CartVO vo) {
		return dao.getCartList(vo);
	}

}
