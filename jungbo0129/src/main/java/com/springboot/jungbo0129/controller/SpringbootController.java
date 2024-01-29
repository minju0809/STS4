package com.springboot.jungbo0129.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringbootController {

  @GetMapping("/main.do")
  public String main() {
    return "/main.html";
  }

}
