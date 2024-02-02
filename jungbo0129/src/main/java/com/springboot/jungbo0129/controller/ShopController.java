package com.springboot.jungbo0129.controller;

import java.io.File;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.springboot.jungbo0129.shop.ProductVO;
import com.springboot.jungbo0129.shop.ShopService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

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

}
