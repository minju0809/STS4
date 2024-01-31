package com.springboot.jungbo0129.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.jungbo0129.member.MemberService;
import com.springboot.jungbo0129.member.MemberVO;
import com.springboot.jungbo0129.money.MoneyService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SpringbootController {

  @Autowired
  private MemberService service;

  @Autowired
  private MoneyService moneyService;

  @Autowired
  private HttpServletRequest request;

  @GetMapping("/main.do")
  public String main() {

    return "/main.html";
  }

  @GetMapping("/memberList")
  public String memberList(Model model) {

    model.addAttribute("li", service.memberList(null));

    return "/member/memberList.html";
  }

  @GetMapping("/member")
  public String member(Model model, MemberVO vo) {

    model.addAttribute("member", service.member(vo));

    return "member/member.html";
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
  public String memberInsert(MemberVO vo) throws Exception {
    System.out.println("===> insert" + vo);

    String address = "(" + vo.getPostcode() + ") " + vo.getAddress() + ", "
        + vo.getDetailAddress() + " " + vo.getExtraAddress();
    vo.setAddress(address);
    System.out.println("주소: " + vo.getAddress());

    service.memberInsert(vo);

    return "redirect:/memberList";
  }

  @GetMapping("/fileForm")
  public String fileForm(Model model, MemberVO vo) {
   
    return "/member/fileForm.html";
  }

  @PostMapping("/fileInsert")
  public String fileInsert(MemberVO vo) throws Exception {
    String path = request.getSession().getServletContext().getRealPath("/img/member/");
    System.out.println("path: " + path);

    // 중복 처리 (시간)
    long time = System.currentTimeMillis();
    SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
    String sdfStr = sdf.format(time);

    MultipartFile file = vo.getFile(); // 파일
    String fileName = file.getOriginalFilename();

    File f = new File(path + fileName); // 경로 안에 있는 파일

    if (!file.isEmpty()) {
      if (f.exists()) {
        String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
        String ext = fileName.substring(fileName.lastIndexOf("."));

        fileName = onlyFileName + "_" + sdfStr + ext;
      }
      // 실제 파일 저장
      file.transferTo(new File(path + fileName));
    } else {
      fileName = "space.png";
    }

    vo.setFiles(fileName); // 테이블에 파일 이름 저장
    System.out.println("&&&&&&&&&&&&&&&&&&&" + vo);

    service.fileInsert(vo);

    return "redirect:/memberList";
  }

  @GetMapping("/memberUpdate")
  public String memberUpdate(MemberVO vo) {

    String address = "(" + vo.getPostcode() + ") " + vo.getAddress() + ", "
        + vo.getDetailAddress() + " " + vo.getExtraAddress();
    vo.setAddress(address);

    service.memberUpdate(vo);

    return "redirect:/memberList";
  }

  @GetMapping("/moneyList")
  public String moneyList(Model model) {

    model.addAttribute("li", moneyService.moneyList(null));

    return "/money/moneyList.html";
  }

}
