package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RubypaperController {

  @GetMapping("/admin/admin.do")
  public String admin() {

    return "admin/index";
  }

  @GetMapping("/manager/manager.do")
  public String manager() {

    return "manager/index";
  }

  @GetMapping("/member/member.do")
  public String member() {

    return "member/index";
  }

  @GetMapping("/member/member2.do")
  public String member2() {

    return "member2/index";
  }

  @GetMapping("/member/memberBoard.do")
  public String memberBoard() {

    return "memberBoard/index";
  }

  @GetMapping("/guest/guest.do")
  public String guest() {

    return "guest/index";
  }

  @GetMapping("/guest/guestBoard.do")
  public String guestBoard() {

    return "guestBoard/index";
  }

}
