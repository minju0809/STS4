package com.springboot.jungbo0129.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.jungbo0129.member.MemberService;

@Controller
public class SpringbootController {

  @Autowired
  private MemberService service;

  @GetMapping("/main.do")
  public String main() {
    return "/main.html";
  }

  @GetMapping("/memberList")
  public String memberList(Model model) {

    model.addAttribute("li", service.memberList(null));

    return "/member/memberList.html";
  }

}
