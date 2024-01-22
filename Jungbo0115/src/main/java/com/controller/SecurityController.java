package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

  @GetMapping("login.do")
  public String login() {

    return "login/login";
  }

  @GetMapping("loginSuccess.do")
  public String loginSuccess() {

    return "login/loginSuccess";
  }

  @GetMapping("accessDenied.do")
  public String accessDenied() {

    return "login/accessDenied";
  }

}
