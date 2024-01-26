package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.login.LoginService;
import com.rubypaper.login.LoginVO;

@Controller
public class UserController {

  @Autowired
  LoginService service;

  @Autowired
  private PasswordEncoder encoder;

  @GetMapping("/getUserList.do")
  public String getUserList(Model model) {

    model.addAttribute("li", service.getUserList(null));
    return "user/getUserList";
  }

  @GetMapping("/admin/userForm.do")
  public String userForm() {

    return "user/userForm";
  }

  @GetMapping("/insert.do")
  public String insert(LoginVO vo) {

    vo.setPassword(encoder.encode(vo.getPassword()));
    vo.setRole("ROLE_" + vo.getRole().toUpperCase());

    service.insert(vo);
    return "redirect:/getUserList.do";
  }
}
