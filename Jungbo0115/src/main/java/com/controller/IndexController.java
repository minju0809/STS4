package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
  IndexController() {
    System.out.println("===> IndexController 확인");
  }

  @GetMapping("security.do")
  public String security() {

    return "security";
  }

}
