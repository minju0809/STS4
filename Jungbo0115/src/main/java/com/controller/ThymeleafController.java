package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.login.LoginService;
import com.rubypaper.login.LoginVO;

@Controller
public class ThymeleafController {

  @Autowired
  private LoginService service;

  @GetMapping("/main")
  public void index(Model model) {
    model.addAttribute("hello", "안녕하세요 타임리프입니다");
  }

  @GetMapping("/getUserList")
  public void getUserList(Model model) {
    model.addAttribute("li", service.getUserList(null));
  }

  @GetMapping("/userForm")
  public void userForm() {
  }

  @GetMapping("/insert")
  public void insert(Model model, LoginVO vo) {
    // service.insert(vo);
  }
}
