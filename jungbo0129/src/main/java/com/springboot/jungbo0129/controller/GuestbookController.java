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

    int start = 0;
    int pageSize = 10;
    int pageListSize = 10;
    int guestbookCount = service.guestbookCount(vo);

    if (vo.getStart() == 0) {
      start = 1;
    } else {
      start = vo.getStart();
    }

    int end = start + pageSize - 1;

    int totalPage = (guestbookCount / pageSize) + 1;
    int currentPage = (start / pageSize) + 1;
    int lastPage = (totalPage - 1) * pageSize + 1;
    int listStartPage = (currentPage - 1) / pageListSize * pageListSize + 1;
    int listEndPage = listStartPage + pageListSize - 1;

    vo.setStart(start);
    vo.setPageSize(pageSize);
    vo.setEnd(end);

    model.addAttribute("guestbookCount", guestbookCount);
    model.addAttribute("start", start);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("end", end);
    model.addAttribute("totalPage", totalPage);
    model.addAttribute("currentPage", currentPage);
    model.addAttribute("lastPage", lastPage);

    model.addAttribute("pageListSize", pageListSize);
    model.addAttribute("listStartPage", listStartPage);
    model.addAttribute("listEndPage", listEndPage);

    // 검색 후 이동 시에 결과값 유지를 위해 필요
    model.addAttribute("ch1", vo.getCh1());
    model.addAttribute("ch2", vo.getCh2());

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
