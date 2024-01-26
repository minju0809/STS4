package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.login.LoginService;
import com.rubypaper.login.LoginVO;

@Controller
public class ThymeleafController {

  @Autowired
  private LoginService service;

  @Autowired
  private PasswordEncoder encoder;

  @GetMapping("/main")
  public void index(Model model) {
    model.addAttribute("hello", "안녕하세요 타임리프입니다");
  }

  @GetMapping("/getUserList")
  public void getUserList(Model model) {
    model.addAttribute("li", service.getUserList(null));
  }

  @GetMapping("/getUser")
  public void getUser(Model model, LoginVO vo) {
    model.addAttribute("user", service.getUser(vo));
  }

  @GetMapping("/userForm")
  public void userForm() {
  }

  @GetMapping("/insert")
  public String insert(Model model, LoginVO vo) {
    vo.setRole("ROLE_" + vo.getRole().toUpperCase());
    service.insert(vo);

    return "redirect:/getUserList";
  }

  @GetMapping("/update")
  public String update(Model model, LoginVO vo) {
    vo.setRole("ROLE_" + vo.getRole().toUpperCase());
    service.update(vo);

    return "redirect:/getUserList";
  }
}
