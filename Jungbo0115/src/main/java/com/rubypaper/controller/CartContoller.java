package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.project.shop.CartVO;
import com.rubypaper.project.shop.ShopService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartContoller {
	
	@Autowired
	private ShopService service;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("getCartAdd.do")
	String getCartAdd(Model model, CartVO vo) {
		
		String sessionId = (String)session.getAttribute("session_id");
		System.out.println("sessionId" + sessionId);
		vo.setSession_id(sessionId);
		
		CartVO productId = service.getProductId(vo);
		System.out.println("product" + productId);
		
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
	
	@GetMapping("sessionLogout.do")
	String sessionLogout(Model model) {
		
//		session.invalidate();
		
		return "redirect:index.do";
	}

}
