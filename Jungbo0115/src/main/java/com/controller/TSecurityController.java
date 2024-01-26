package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.login.LoginService;
import com.rubypaper.login.LoginVO;
import com.rubypaper.security.SecurityUser;

import jakarta.servlet.http.HttpSession;

@Controller
public class TSecurityController {

  @Autowired
  LoginService service;

  @Autowired
  HttpSession session;

  @GetMapping("/login.do")
  public String login() {

    return "/security/login.html";
  }

  @GetMapping("/loginSuccess.do")
  public String loginSuccess(@AuthenticationPrincipal SecurityUser user) {

    LoginVO vo = new LoginVO();
    vo.setUsername(user.getUsername());

    session.setAttribute("user", service.loginOK(vo));

    return "/security/loginSuccess.html";
  }

  @GetMapping("/accessDenied.do")
  public String accessDenied() {

    return "/security/accessDenied.html";
  }

  @GetMapping("/logout.do")
  public String logout() {

    return "/security/logout.html";
  }

}
