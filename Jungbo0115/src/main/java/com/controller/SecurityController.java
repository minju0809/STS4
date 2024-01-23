package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SecurityController {

  @Autowired
  HttpSession session;

  @GetMapping("login.do")
  public String login() {

    return "login/login";
  }

  @GetMapping("loginSuccess.do")
  public String loginSuccess(Principal user) {
    session.setAttribute("session", (String) user.getName());

    return "login/loginSuccess";
  }

  @GetMapping("accessDenied.do")
  public String accessDenied() {

    return "login/accessDenied";
  }

}
