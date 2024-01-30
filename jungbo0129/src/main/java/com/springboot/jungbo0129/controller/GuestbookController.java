package com.springboot.jungbo0129.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.springboot.jungbo0129.guestbook.GuestbookService;
import com.springboot.jungbo0129.guestbook.GuestbookVO;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestbookController {

  @Autowired
  private GuestbookService service;

  @GetMapping("/guestbookList")
  String guestbookList(Model model, GuestbookVO vo) {

    model.addAttribute("li", service.guestbookList(vo));

    return "/guestbook/guestbookList.html";
  }

  @GetMapping("/guestbookAdd")
  String guestbookAdd(GuestbookVO vo) {

    String[] nameArr = { "하늘이", "둘리", "세실", "사샤", "오공", "육룡", "칠득이", "팔괴", "구동", "열매" };
    String[] memoArr = { "아주 좋아요", "또 오고 싶어요", "반가웠습니다", "만족합니다", "도움이 많이 되었습니다" };

    Random ran = new Random();

    for (int i = 0; i < 100; i++) {
      String name = nameArr[ran.nextInt(nameArr.length)];
      String memo = name + " " + memoArr[ran.nextInt(memoArr.length)];

      vo.setName(name);
      vo.setMemo(memo);

      service.guestbookAdd(vo);
    }

    return "redirect:/guestbookList";
  }

}
