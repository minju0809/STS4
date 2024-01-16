package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.project.shop.CartVO;
import com.rubypaper.project.shop.ShopService;

@Controller
public class CartContoller {
	
	@Autowired
	private ShopService service;
	
	@GetMapping("getCartAdd.do")
	String getCartList(Model model, CartVO vo) {

		CartVO productId = service.getProductId(vo);
		System.out.println(productId);
		
		if (productId == null) {
			service.cartInsert(vo);
		} else {
			service.cartUpdate(vo);
		}
		
		model.addAttribute("li", service.getCartList(null));
		
		return "/shop/getCartList";
	}
	
	@GetMapping("getCartList.do")
	String getCartList(Model model) {
		model.addAttribute("li", service.getCartList(null));
		
		return "/shop/getCartList";
	}

}
