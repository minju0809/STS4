package com.springboot.jungbo0129.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.jungbo0129.member.MemberService;
import com.springboot.jungbo0129.member.MemberVO;

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

  @GetMapping("/memberForm")
  public String memberForm(Model model, MemberVO vo) {

    Date toDay = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String toDayStr = sdf.format(toDay);

    model.addAttribute("custno", service.custno());
    model.addAttribute("toDayStr", toDayStr);

    return "/member/memberForm.html";
  }

  @GetMapping("/memberInsert")
  public String memberInsert(MemberVO vo) {
    System.out.println("===> insert" + vo);

    service.memberInsert(vo);

    return "redirect:/memberList";
  }

}
