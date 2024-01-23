package com.controller;

// import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.login.LoginService;
import com.rubypaper.login.LoginVO;
import com.rubypaper.security.SecurityUser;

import jakarta.servlet.http.HttpSession;

@Controller
public class SecurityController {

  @Autowired
  LoginService service;

  @Autowired
  HttpSession session;

  @GetMapping("login.do")
  public String login() {

    return "login/login";
  }

  @GetMapping("loginSuccess.do")
  public String loginSuccess(@AuthenticationPrincipal SecurityUser user) {

    LoginVO vo = new LoginVO();
    vo.setUsername(user.getUsername());

    session.setAttribute("session", service.loginOK(vo));

    return "login/loginSuccess";
  }

  @GetMapping("accessDenied.do")
  public String accessDenied() {

    return "login/accessDenied";
  }

}
