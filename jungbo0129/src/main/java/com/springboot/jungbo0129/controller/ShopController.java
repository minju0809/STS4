package com.springboot.jungbo0129.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.springboot.jungbo0129.shop.CartVO;
import com.springboot.jungbo0129.shop.OrderVO;
import com.springboot.jungbo0129.shop.ProductVO;
import com.springboot.jungbo0129.shop.ShopService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {

  @Autowired
  private ShopService service;

  @Autowired
  private HttpServletRequest request;

  @GetMapping("/productList.do")
  String productList(ProductVO vo, Model model) {

    model.addAttribute("li", service.productList(vo));
    return "/shop/productList";
  }

  @GetMapping("/product.do")
  String product(ProductVO vo, Model model) {

    model.addAttribute("product", service.product(vo));
    return "/shop/product";
  }

  @GetMapping("/productForm.do")
  String productForm() {

    return "/shop/productForm";
  }

  @PostMapping("/productInsert.do")
  String productInsert(ProductVO vo) throws Exception {
    String path = request.getSession().getServletContext().getRealPath("/img/shop/");
    System.out.println("path: " + path);

    // 중복 처리 (시간)
    long time = System.currentTimeMillis();
    SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
    String sdfStr = sdf.format(time);

    MultipartFile file = vo.getProduct_img(); // 파일
    String fileName = file.getOriginalFilename();

    File f = new File(path + fileName); // 경로 안에 있는 파일

    if (!file.isEmpty()) {
      if (f.exists()) {
        String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
        String ext = fileName.substring(fileName.lastIndexOf("."));

        fileName = onlyFileName + "_" + sdfStr + ext;
      }
      // 실제 파일 저장
      file.transferTo(new File(path + fileName));
    } else {
      fileName = "space.png";
    }

    vo.setProduct_imgStr(fileName); // 테이블에 파일 이름 저장
    service.productInsert(vo);

    return "redirect:/productList.do";
  }

  @PostMapping("/cartAdd.do")
  String cartAdd(CartVO vo) {

    // System.out.println("@@@@cvo: " + vo);

    CartVO checkVO = service.cartCheck(vo);

    if (checkVO == null) {
      service.cartInsert(vo);
    } else {
      service.cartUpdate(vo);
    }

    return "redirect:/cartList.do";
  }

  @GetMapping("/cartList.do")
  String cartList(CartVO vo, Model model) {
    List<CartVO> cartList = service.cartList(vo);

    int total = 0;
    for (CartVO cart : cartList) {
      total += cart.getTotal_price();
    }

    model.addAttribute("li", cartList);
    model.addAttribute("total", total);

    return "/shop/cartList";
  }

  @PostMapping("/orderAll.do")
  String orderAll(OrderVO vo) {

    // System.out.println("@@@@cvo: " + vo);

    return "redirect:/orderList.do";
  }

  @GetMapping("/orderList.do")
  String orderList(OrderVO vo, Model model) {

    // model.addAttribute("li", );

    return "/shop/orderList";
  }

}
