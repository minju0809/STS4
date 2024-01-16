package com.rubypaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.rubypaper.project.shop.ProductVO;
import com.rubypaper.project.shop.ShopService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopController {
	@Autowired
	private ShopService service;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("getShopList.do")
	String getShopList(Model model) {
		model.addAttribute("li", service.getShopList(null));
		
		return "/shop/getShopList";
	}
	
	@GetMapping("getShop.do")
	String getShop(Model model, ProductVO vo) {
		model.addAttribute("m", service.getShop(vo));
		
		return "/shop/getShop";
	}
	
	@GetMapping("shopForm.do")
	String shopForm(Model model) {
		System.out.println("form");
		model.addAttribute("product_id", service.getId());
		
		return "/shop/shopForm";
	}
	
	@PostMapping("shopInsert.do")
	String shopInsert(ProductVO vo) throws Exception, IOException {
		
		String path = request.getSession().getServletContext().getRealPath("/shop/img/");
		System.out.println("path: "+path);
		
		// 중복 처리 (시간)
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String sdfStr = sdf.format(time);
		
		MultipartFile file = vo.getProduct_img(); // 파일 
		String fileName = file.getOriginalFilename();
		
		File f = new File(path+fileName); // 경로 안에 있는 파일
		
		if(!file.isEmpty()) {
			if(f.exists()) {
				String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
				String ext = fileName.substring(fileName.lastIndexOf("."));
				
				fileName = onlyFileName + "_" + sdfStr + ext;
			} 
			// 실제 파일 저장
			file.transferTo(new File(path+fileName));
		} else {
			fileName = "space.png";
		}
		
		vo.setProduct_imgStr(fileName); // 테이블에 파일 이름 저장
		
		service.insert(vo);
		
		return "redirect:getShopList.do";
	}
	
	@GetMapping("cart.do")
	String buy(ProductVO vo) throws Exception, IOException {
		
		String path = request.getSession().getServletContext().getRealPath("/shop/img/");
		System.out.println("path: "+path);
		
		return "redirect:getShopList.do";
	}

}
